import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, K, dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(in.readLine());
        K = 20;
        dp = new int[M + 1][K];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= M; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
        }
        initSparseTable();
        int Q = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(Q-- > 0) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            sb.append(getFunc(N, X)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void initSparseTable() {
        for (int k = 1; k < K; k++) {
            for (int i = 1; i <= M; i++) {
                dp[i][k] = dp[dp[i][k - 1]][k - 1];
            }
        }
    }

    static int getFunc(int N, int X) {
        for (int k = 0; k < K; k++) {
            if((N & (1 << k)) > 0)
                X = dp[X][k];
        }
        return X;
    }
}