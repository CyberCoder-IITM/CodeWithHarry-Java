import java.util.*;
import java.util.function.BiFunction;

public class DynamicExpressionEngine {
    
    static class OperatorRegistry {
        private Map<String, Operator> operators = new HashMap<>();
        
        record Operator(int precedence, boolean leftAssociative, 
                       BiFunction<Double, Double, Double> operation) {}
        
        OperatorRegistry() {
            // Standard operators
            register("^", 4, false, Math::pow);
            register("*", 3, true, (a, b) -> a * b);
            register("/", 3, true, (a, b) -> a / b);
            register("+", 2, true, (a, b) -> a + b);
            register("-", 2, true, (a, b) -> a - b);
            
            // Custom operators
            register("@", 5, true, (a, b) -> Math.max(a, b)); // max
            register("#", 5, true, (a, b) -> Math.min(a, b)); // min
            register("%", 3, true, (a, b) -> a % b);          // modulo
            register("&", 1, true, (a, b) -> (a + b) / 2);    // average
        }
        
        void register(String symbol, int precedence, boolean leftAssoc, 
                     BiFunction<Double, Double, Double> op) {
            operators.put(symbol, new Operator(precedence, leftAssoc, op));
        }
        
        Operator get(String symbol) {
            return operators.get(symbol);
        }
        
        boolean contains(String symbol) {
            return operators.containsKey(symbol);
        }
    }
    
    static class ExpressionEvaluator {
        private OperatorRegistry registry;
        
        ExpressionEvaluator(OperatorRegistry registry) {
            this.registry = registry;
        }
        
        // Shunting Yard Algorithm with custom operators
        List<String> toPostfix(String expression) {
            List<String> output = new ArrayList<>();
            Deque<String> operatorStack = new ArrayDeque<>();
            
            String[] tokens = expression.split("\\s+");
            
            for (String token : tokens) {
                if (isNumeric(token)) {
                    output.add(token);
                } else if (registry.contains(token)) {
                    while (!operatorStack.isEmpty() && 
                           registry.contains(operatorStack.peek())) {
                        var op1 = registry.get(token);
                        var op2 = registry.get(operatorStack.peek());
                        
                        if ((op1.leftAssociative() && op1.precedence() <= op2.precedence()) ||
                            (!op1.leftAssociative() && op1.precedence() < op2.precedence())) {
                            output.add(operatorStack.pop());
                        } else {
                            break;
                        }
                    }
                    operatorStack.push(token);
                } else if (token.equals("(")) {
                    operatorStack.push(token);
                } else if (token.equals(")")) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        output.add(operatorStack.pop());
                    }
                    if (!operatorStack.isEmpty()) operatorStack.pop(); // Remove '('
                }
            }
            
            while (!operatorStack.isEmpty()) {
                output.add(operatorStack.pop());
            }
            
            return output;
        }
        
        double evaluate(String expression) {
            List<String> postfix = toPostfix(expression);
            Deque<Double> stack = new ArrayDeque<>();
            
            for (String token : postfix) {
                if (isNumeric(token)) {
                    stack.push(Double.parseDouble(token));
                } else if (registry.contains(token)) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = registry.get(token).operation().apply(a, b);
                    stack.push(result);
                }
            }
            
            return stack.pop();
        }
        
        private boolean isNumeric(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        OperatorRegistry registry = new OperatorRegistry();
        ExpressionEvaluator evaluator = new ExpressionEvaluator(registry);
        
        System.out.println("=== Dynamic Expression Engine ===\n");
        System.out.println("Custom Operators:");
        System.out.println("@ = max, # = min, & = average, ^ = power\n");
        
        String[] expressions = {
            "3 + 5 * 2",
            "10 @ 25",           // max(10, 25)
            "10 # 25",           // min(10, 25)
            "20 & 30",           // average(20, 30)
            "2 ^ 3 + 5",         // 2^3 + 5
            "( 10 @ 5 ) * 2",    // max(10,5) * 2
            "100 # 50 & 75"      // average(min(100,50), 75)
        };
        
        for (String expr : expressions) {
            double result = evaluator.evaluate(expr);
            List<String> postfix = evaluator.toPostfix(expr);
            System.out.printf("Expression: %-25s\n", expr);
            System.out.printf("Postfix:    %-25s\n", String.join(" ", postfix));
            System.out.printf("Result:     %.2f\n\n", result);
        }
    }
}