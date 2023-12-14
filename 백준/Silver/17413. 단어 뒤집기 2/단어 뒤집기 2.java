import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for(Character c : in.readLine().toCharArray()){
            if(c.equals('<')) {
                flag = true;
                reverseWord(stack, sb);
            }
            if(c.equals('>')) {
                flag = false;
                sb.append(c);
                continue;
            }
            if(flag){
                sb.append(c);
                continue;
            }
            if(c.equals(' ')) {
                reverseWord(stack, sb);
                sb.append(" ");
                continue;
            }
            stack.push(c);
        }
        reverseWord(stack, sb);
        System.out.println(sb);
        in.close();
    }

    static void reverseWord(Stack stack, StringBuilder sb){
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }
}