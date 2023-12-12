import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int num = 1;
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(in.readLine());
            while(num <= N + 1){
                if(!stack.isEmpty() && next == stack.peek()) {
                    pop();
                    break;
                }
                push(num++);
            }
        }
        if(!stack.isEmpty()) sb = new StringBuilder("NO");
        System.out.print(sb);
        in.close();
    }

    static void push(int num){
        sb.append("+").append("\n");
        stack.push(num);
    }
    static int pop(){
        sb.append("-").append("\n");
        return stack.pop();
    }

}