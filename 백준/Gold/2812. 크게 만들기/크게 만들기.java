import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(char c : in.readLine().toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && cnt != K) {
                stack.pop();
                cnt++;
            }
            stack.push(c);
        }
        while(stack.size() != N - K) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
        in.close();
    }

}