import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(in.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(in.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
        in.close();
    }
}