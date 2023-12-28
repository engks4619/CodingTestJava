import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            int curr = arr[i];
            dp[i] = curr;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < curr) {
                    dp[i] = Math.max(dp[i], dp[j] + curr);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
        in.close();
    }
}