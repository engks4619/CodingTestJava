import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmpStack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            int num = arr[i];
            while(!tmpStack.isEmpty() && num >= tmpStack.peek()){
                tmpStack.pop();
            }
            if(tmpStack.isEmpty()){
                stack.push(-1);
                tmpStack.push(num);
                continue;
            }
            stack.push(tmpStack.peek());
            tmpStack.push(num);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
        in.close();
    }
}