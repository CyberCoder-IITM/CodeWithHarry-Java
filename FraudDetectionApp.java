import java.util.*;

/**
 * Standalone Fraud Transaction Detector (single-file Java program)
 * Deloitte-style: business rules + sliding window + HashMap optimization
 */
public class FraudDetectionApp {

    // --------- Model ----------
    static class Transaction {
        private final String userId;
        private final double amount;
        private final String location;
        private final long timestamp; // epoch millis

        public Transaction(String userId, double amount, String location, long timestamp) {
            this.userId = userId;
            this.amount = amount;
            this.location = location;
            this.timestamp = timestamp;
        }

        public String getUserId() { return userId; }
        public double getAmount() { return amount; }
        public String getLocation() { return location; }
        public long getTimestamp() { return timestamp; }

        @Override
        public String toString() {
            return "Transaction{userId='" + userId + "', amount=" + amount +
                    ", location='" + location + "', timestamp=" + timestamp + "}";
        }
    }

    // --------- Fraud Engine ----------
    static class FraudDetector {
        private final int maxTransactions;
        private final long timeWindowMillis;
        private final double maxAmount;

        // userId -> recent tx list within window
        private final Map<String, List<Transaction>> userTransactions = new HashMap<>();

        public FraudDetector(int maxTransactions, int timeWindowMinutes, double maxAmount) {
            if (maxTransactions <= 0) throw new IllegalArgumentException("maxTransactions must be > 0");
            if (timeWindowMinutes <= 0) throw new IllegalArgumentException("timeWindowMinutes must be > 0");
            if (maxAmount <= 0) throw new IllegalArgumentException("maxAmount must be > 0");

            this.maxTransactions = maxTransactions;
            this.timeWindowMillis = timeWindowMinutes * 60_000L;
            this.maxAmount = maxAmount;
        }

        /**
         * Rules:
         * 1) Amount > maxAmount => suspicious
         * 2) More than maxTransactions within timeWindow => suspicious
         * 3) Different locations within timeWindow => suspicious
         */
        public Result evaluate(Transaction tx) {
            // Rule 1: High value
            if (tx.getAmount() > maxAmount) {
                return new Result(true, "High-value transaction: amount exceeds limit (" + maxAmount + ")");
            }

            userTransactions.putIfAbsent(tx.getUserId(), new ArrayList<>());
            List<Transaction> recent = userTransactions.get(tx.getUserId());

            // Keep only transactions within time window
            long cutoff = tx.getTimestamp() - timeWindowMillis;
            recent.removeIf(t -> t.getTimestamp() < cutoff);

            // Rule 2: Too many transactions in window
            // If current tx makes it exceed threshold => suspicious
            if (recent.size() >= maxTransactions) {
                return new Result(true, "Rapid frequency: more than " + maxTransactions +
                        " transactions within " + (timeWindowMillis / 60_000L) + " minutes");
            }

            // Rule 3: Multiple locations quickly
            for (Transaction t : recent) {
                if (!t.getLocation().equalsIgnoreCase(tx.getLocation())) {
                    long delta = Math.abs(tx.getTimestamp() - t.getTimestamp());
                    if (delta <= timeWindowMillis) {
                        return new Result(true, "Location anomaly: multiple locations within " +
                                (timeWindowMillis / 60_000L) + " minutes (" + t.getLocation() +
                                " -> " + tx.getLocation() + ")");
                    }
                }
            }

            recent.add(tx);
            return new Result(false, "OK");
        }
    }

    // --------- Result ----------
    static class Result {
        final boolean suspicious;
        final String reason;

        Result(boolean suspicious, String reason) {
            this.suspicious = suspicious;
            this.reason = reason;
        }

        @Override
        public String toString() {
            return (suspicious ? "SUSPICIOUS" : "NORMAL") + " - " + reason;
        }
    }

    // --------- Demo Runner ----------
    public static void main(String[] args) {
        // Config (can be changed quickly)
        int maxTx = 3;              // allow up to 3 in window
        int windowMinutes = 5;      // time window
        double maxAmount = 5000.0;  // high value threshold

        FraudDetector detector = new FraudDetector(maxTx, windowMinutes, maxAmount);

        long now = System.currentTimeMillis();

        List<Transaction> demo = List.of(
                new Transaction("User1", 1000, "Boston",   now),
                new Transaction("User1", 1200, "Boston",   now + 60_000),
                new Transaction("User1", 1500, "New York", now + 120_000), // location anomaly
                new Transaction("User2", 6000, "Miami",    now + 180_000), // high value
                new Transaction("User3", 50,   "Boston",   now + 240_000),
                new Transaction("User3", 60,   "Boston",   now + 250_000),
                new Transaction("User3", 70,   "Boston",   now + 260_000),
                new Transaction("User3", 80,   "Boston",   now + 270_000)  // rapid frequency
        );

        System.out.println("=== Fraud Detection Demo ===");
        System.out.println("Rules: maxTx=" + maxTx + ", windowMinutes=" + windowMinutes + ", maxAmount=" + maxAmount);
        System.out.println();

        for (int i = 0; i < demo.size(); i++) {
            Transaction tx = demo.get(i);
            Result r = detector.evaluate(tx);
            System.out.println((i + 1) + ") " + tx);
            System.out.println("   -> " + r);
        }
    }
}