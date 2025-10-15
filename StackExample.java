import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        boolean StackEmptyOrNot = stk.empty();
        System.out.println("Stack Is Empty :" +StackEmptyOrNot);
        stk.push(68);
        stk.push(676);
        stk.push(222);
        System.out.println("Elements in stack are :"+ stk);

        boolean resultEmptyOrNot = stk.empty();

        System.out.println("Stack is Empty:" + resultEmptyOrNot);
        System.out.println("Popped Element 1st :" + stk.pop());
        System.out.println("Popped Element 2st :" + stk.pop());
        System.out.println("Popped Element 3st :" + stk.pop());
        System.out.println("Popped Element last :" + stk.pop());

    }
}
