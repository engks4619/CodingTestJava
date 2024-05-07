import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        int left = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int right = arr[i];
            if(right >= left) {
                while(!stack.isEmpty()) {
                    water += left - stack.pop();
                }
                left = right;
            }
            else stack.push(arr[i]);
        }
        // 더 높거나 같은 값이 안나온 경우 스택에 남은 나머지 처리
        if(!stack.isEmpty()) {
            int right = stack.pop();
            while(!stack.isEmpty()) {
                int curr = stack.pop();
                if(curr > right) right = curr;
                else water += right - curr;
            }
        }
        System.out.println(water);
        in.close();
    }

}