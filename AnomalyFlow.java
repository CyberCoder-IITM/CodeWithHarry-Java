import java.util.LinkedList;
import java.util.Random;

/**
 * AnomalyFlow - Real-Time Log Anomaly Detector.
 * * CONCEPT:
 * Simulates processing a stream of login failures. It calculates the moving 
 * average of failures over a window of time and flags an "Anomaly" if the 
 * current failure rate exceeds the average by a defined threshold (Standard Deviation).
 */
public class AnomalyFlow {

    // Configuration
    private static final int WINDOW_SIZE = 10; // Number of historical data points to consider
    private static final double THRESHOLD_STD_DEVS = 2.0; // Flag an alert if the rate is 2.0 standard deviations above average
    
    // Rolling Data Structure
    private final LinkedList<Integer> history = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        AnomalyFlow detector = new AnomalyFlow();
        Random random = new Random();
        
        System.out.println("--- ANOMALY FLOW: BRUTE FORCE DETECTOR ---");
        System.out.println("Monitoring live login stream...");

        for (int i = 0; i < 50; i++) {
            // Simulate normal log traffic with occasional small spikes (0-3 failures)
            int currentFailures = random.nextInt(4); 

            // Simulate a strong brute-force attempt after 25 cycles
            if (i == 25) { 
                currentFailures = 15; // A massive, sudden spike in failures
                System.out.println("\n🔥 SIMULATING BRUTE FORCE SPIKE 🔥");
            }
            
            detector.processEvent(i, currentFailures);
            Thread.sleep(300); // Simulate processing time
        }
    }

    public void processEvent(int timeStep, int currentFailures) {
        if (history.size() >= WINDOW_SIZE) {
            history.removeFirst(); // Remove the oldest data point
        }
        history.addLast(currentFailures); // Add the newest data point

        if (history.size() == WINDOW_SIZE) {
            double mean = calculateMean();
            double stdDev = calculateStdDev(mean);
            
            // Anomaly Check: Is the current failure rate > Mean + (Threshold * StdDev)?
            if (currentFailures > (mean + (THRESHOLD_STD_DEVS * stdDev))) {
                System.out.printf("[%d] 🚨 ALERT! Failures: %d. Mean: %.2f. Deviation: %.2f.\n", 
                                  timeStep, currentFailures, mean, stdDev);
            } else {
                System.out.printf("[%d] OK. Failures: %d. Mean: %.2f. StdDev: %.2f.\n", 
                                  timeStep, currentFailures, mean, stdDev);
            }
        } else {
            System.out.printf("[%d] INITIALIZING: Collected %d/%d data points.\n", 
                                timeStep, history.size(), WINDOW_SIZE);
        }
    }

    private double calculateMean() {
        double sum = 0;
        for (int i : history) {
            sum += i;
        }
        return sum / history.size();
    }

    private double calculateStdDev(double mean) {
        double squaredDifferences = 0;
        for (int i : history) {
            squaredDifferences += Math.pow(i - mean, 2);
        }
        double variance = squaredDifferences / history.size();
        return Math.sqrt(variance);
    }
}