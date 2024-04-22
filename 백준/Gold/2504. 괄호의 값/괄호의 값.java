import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S = in.readLine();
        int result = 0;
        int sum = 1;
        Stack<Character> stack = new Stack<>();
        boolean isCorrect = true;
        outer : for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            switch (c) {
                case '(' :
                    sum *= 2;
                    stack.push(c);
                    break;
                case '[' :
                    sum *= 3;
                    stack.push(c);
                    break;
                case ')' :
                    if(stack.isEmpty() || stack.peek() != '(') {
                        isCorrect = false;
                        break outer;
                    }
                    if(S.charAt(i - 1) == '(') result += sum;
                    stack.pop();
                    sum /= 2;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') {
                        isCorrect = false;
                        break outer;
                    }
                    if(S.charAt(i - 1) == '[') result += sum;
                    stack.pop();
                    sum /= 3;
                    break;
            }
        }
        if(!stack.isEmpty()) isCorrect = false;
        System.out.println(isCorrect ? result : 0);
        in.close();
    }

}