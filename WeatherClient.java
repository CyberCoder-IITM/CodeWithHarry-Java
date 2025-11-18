import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * A simple command-line weather client that fetches and displays
 * the current weather for a given latitude and longitude using the
 * Open-Meteo API.
 *
 * Usage: java WeatherClient.java <latitude> <longitude>
 * Example: java WeatherClient.java 42.3601 -71.0589
 */
public class WeatherClient {

    // The base URL for the Open-Meteo API
    private static final String API_URL_TEMPLATE = 
        "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true";

    public static void main(String[] args) {
        // 1. Validate command-line arguments
        if (args.length != 2) {
            System.out.println("Usage: java WeatherClient <latitude> <longitude>");
            System.out.println("Example: java WeatherClient 42.3601 -71.0589 (for Boston, MA)");
            return;
        }

        String latitude = args[0];
        String longitude = args[1];

        try {
            // 2. Build the API URL
            String apiUrl = String.format(API_URL_TEMPLATE, latitude, longitude);
            
            // 3. Create an HttpClient
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // 4. Build the HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET() // This is the default, but good to be explicit
                    .build();

            // 5. Send the request and get the response
            System.out.println("Fetching weather for (" + latitude + ", " + longitude + ")...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 6. Check the response status and parse the data
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                parseAndDisplayWeather(responseBody);
            } else {
                System.out.println("Error: Failed to fetch weather data. Status code: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: An exception occurred while fetching data.");
            e.printStackTrace();
        }
    }

    /**
     * A very simple JSON parser to extract the data we need.
     * Note: For a real application, you would use a JSON library 
     * like Gson or Jackson, but this keeps it standalone.
     *
     * @param jsonResponse The JSON string from the API.
     */
    private static void parseAndDisplayWeather(String jsonResponse) {
        try {
            // Find the "current_weather" object
            String cwToken = "\"current_weather\":{";
            int cwIndex = jsonResponse.indexOf(cwToken);
            if (cwIndex == -1) {
                System.out.println("Could not find 'current_weather' in response.");
                return;
            }

            // Find the end of the current_weather object
            int cwEndIndex = jsonResponse.indexOf("}", cwIndex);
            String currentWeather = jsonResponse.substring(cwIndex + cwToken.length(), cwEndIndex);

            // Extract values using simple string manipulation
            String temperature = getValue(currentWeather, "\"temperature\":");
            String windSpeed = getValue(currentWeather, "\"windspeed\":");
            String time = getValue(currentWeather, "\"time\":").replace("\"", ""); // Remove quotes

            System.out.println("\n--- Current Weather ---");
            System.out.println("As of: " + time);
            System.out.println("Temperature: " + temperature + " °C");
            System.out.println("Wind Speed: " + windSpeed + " km/h");
            System.out.println("-------------------------");

        } catch (Exception e) {
            System.out.println("Error: Failed to parse the weather data.");
            System.out.println("Response body: " + jsonResponse);
            e.printStackTrace();
        }
    }

    /**
     * Helper function to extract a value from a JSON snippet.
     * Finds "key":<value>
     */
    private static String getValue(String jsonSnippet, String key) {
        int keyIndex = jsonSnippet.indexOf(key);
        if (keyIndex == -1) {
            return "N/A";
        }
        int valueStartIndex = keyIndex + key.length();
        int valueEndIndex = jsonSnippet.indexOf(",", valueStartIndex); // Find next comma
        if (valueEndIndex == -1) { // If it's the last item
            valueEndIndex = jsonSnippet.length();
        }
        return jsonSnippet.substring(valueStartIndex, valueEndIndex).trim();
    }
}