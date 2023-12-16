import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] A = new int[N];
        Map<Integer, Integer> F = new HashMap<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : A) {
            if (F.containsKey(num)) F.put(num, F.get(num) + 1);
            else F.put(num, 1);
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmpStack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while(!tmpStack.isEmpty() && F.get(A[i]) >= F.get(tmpStack.peek())){
                tmpStack.pop();
            }
            if(tmpStack.isEmpty()){
                stack.push(-1);
                tmpStack.push(A[i]);
                continue;
            }
            stack.push(tmpStack.peek());
            tmpStack.push(A[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);        
        in.close();
    }
}