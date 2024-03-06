import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getMaxArea(N, arr)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static long getMaxArea(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for (int i = 0; i < N; i++) {
            while((!stack.isEmpty() && arr[stack.peek()] >= arr[i])) {
                long height = arr[stack.pop()];
                long width = stack.isEmpty() ? i : (i - 1) - stack.peek();
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            long height = arr[stack.pop()];
            long width = stack.isEmpty() ? N : (N - 1) - stack.peek();
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }

}