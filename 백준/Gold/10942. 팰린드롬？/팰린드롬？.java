import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        int[] data = new int[N + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < N; i++) {
            if (data[i] == data[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (data[j] == data[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }
        int M = Integer.parseInt(in.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(in.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}