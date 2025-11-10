import java.util.Arrays;

/**
 * A simple Java program to demonstrate Linear Regression.
 * It uses the "Ordinary Least Squares" (OLS) method
 * to find the best-fit line for a set of 2D data points.
 */
public class LinearRegression {

    public static void main(String[] args) {
        // 1. Sample Data
        // These are our (x, y) data points
        double[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] y = { 2, 4, 5, 7, 8, 10, 12, 13, 15, 17 };

        // 2. Calculate the regression coefficients (b0 and b1)
        double[] coefficients = calculateCoefficients(x, y);
        
        double b0 = coefficients[0]; // Intercept
        double b1 = coefficients[1]; // Slope

        // 3. Print the resulting regression equation
        System.out.println("--- Linear Regression Results ---");
        System.out.printf("The best-fit line is: y = %.4fx + %.4f\n", b1, b0);
        System.out.println("---------------------------------");


        // 4. Make a prediction for a new x value
        double xToPredict = 11.0;
        double yPredicted = predict(xToPredict, b0, b1);
        
        System.out.printf("\nPrediction for x = %.1f:\n", xToPredict);
        System.out.printf("Predicted y = %.4f\n", yPredicted);
    }

    /**
     * Calculates the regression coefficients (b0 and b1) using OLS.
     * @param x The array of independent variable (x) values.
     * @param y The array of dependent variable (y) values.
     * @return A double array [b0, b1], where b0 is the intercept and b1 is the slope.
     */
    public static double[] calculateCoefficients(double[] x, double[] y) {
        int n = x.length;
        if (n != y.length) {
            throw new IllegalArgumentException("Data arrays must have the same length.");
        }

        // --- Step 1: Calculate the means of x and y ---
        double meanX = Arrays.stream(x).average().orElse(0);
        double meanY = Arrays.stream(y).average().orElse(0);

        // --- Step 2: Calculate the sum of squares ---
        // Numerator (SS_xy): Sum of (x_i - meanX) * (y_i - meanY)
        // Denominator (SS_xx): Sum of (x_i - meanX)^2
        double ssXY = 0;
        double ssXX = 0;

        for (int i = 0; i < n; i++) {
            ssXY += (x[i] - meanX) * (y[i] - meanY);
            ssXX += (x[i] - meanX) * (x[i] - meanX);
        }

        // --- Step 3: Calculate slope (b1) and intercept (b0) ---
        // Slope b1 = SS_xy / SS_xx
        double b1 = ssXY / ssXX;

        // Intercept b0 = meanY - (b1 * meanX)
        double b0 = meanY - (b1 * meanX);

        // Return the coefficients [intercept, slope]
        return new double[]{b0, b1};
    }

    /**
     * Predicts the y value for a given x value using the regression line.
     * @param x The x value to predict for.
     * @param b0 The intercept of the line.
     * @param b1 The slope of the line.
     * @return The predicted y value.
     */
    public static double predict(double x, double b0, double b1) {
        return b1 * x + b0;
    }
}