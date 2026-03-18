import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * HoneyDrive_Sentinel
 * A basic Cybersecurity Honeypot utility that opens a decoy port
 * and logs unauthorized access attempts for intrusion detection.
 */
public class HoneyDrive_Sentinel {

    private static final int DECOY_PORT = 8080; // Can be changed to 21 (FTP), 23 (Telnet), etc.
    private static final String LOG_FILE = "honeypot_log.txt";

    public static void main(String[] args) {
        System.out.println("--- HoneyDrive Sentinel Active ---");
        System.out.println("Monitoring for intruders on port: " + DECOY_PORT);
        System.out.println("Logs will be saved to: " + LOG_FILE);

        try (ServerSocket serverSocket = new ServerSocket(DECOY_PORT)) {
            while (true) {
                try (Socket intruderSocket = serverSocket.accept()) {
                    String intruderIP = intruderSocket.getInetAddress().toString();
                    logAttempt(intruderIP, "Connection Established");

                    PrintWriter out = new PrintWriter(intruderSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(intruderSocket.getInputStream()));

                    // Simulate a fake system prompt to lure the intruder
                    out.println("Ubuntu 22.04.3 LTS");
                    out.print("login: ");
                    out.flush();

                    String attempt = in.readLine();
                    logAttempt(intruderIP, "Login Attempt: " + attempt);

                    out.println("Access Denied. Connection Closed.");
                    System.out.println("[!] Alert: Unauthorized access detected from " + intruderIP);
                } catch (IOException e) {
                    System.err.println("Error handling intruder: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + DECOY_PORT + ". Is it already in use?");
        }
    }

    private static void logAttempt(String ip, String details) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("[" + new Date() + "] IP: " + ip + " | Details: " + details);
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
