import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        int ans = 0;
        for (int i = 2; i < N; i++) {
            //벌 1 벌 i 벌통 N
            ans = Math.max(ans, (sum[N] - arr[1] - arr[i]) + (sum[N] - sum[i]));
            //벌통 1 벌 i 벌 N
            ans = Math.max(ans, sum[i - 1] + (sum[N - 1] - arr[i]));
            //벌 1 벌통 i 벌 N
            ans = Math.max(ans, (sum[i] - arr[1]) + (sum[N - 1] - sum[i - 1]));
        }
        System.out.println(ans);
        in.close();
    }
}