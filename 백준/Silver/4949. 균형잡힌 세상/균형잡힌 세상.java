import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = in.readLine();
            if(str.equals(".")) break;
            sb.append(isBalancedString(str) ? "yes" : "no").append("\n");
        }
        System.out.print(sb);
        in.close();
    }
    static boolean isBalancedString(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.add(c);
                continue;
            }
            if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
            if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
        }
        return stack.isEmpty();
    }
}