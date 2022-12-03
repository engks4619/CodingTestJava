import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, data[][], dp[][];
    final static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][(1 << N) - 1];
        System.out.println(tsp(0, 1));
        in.close();
    }

    public static int tsp(int curr, int visit) {
        //모든 도시 방문 완료한 경우
        if (visit == (1 << N) - 1) {
            if (data[curr][0] == 0)
                return INF;
            else
                return data[curr][0];
        }
        //이미 방문한 도시인 경우
        if (dp[curr][visit] != 0) {
            return dp[curr][visit];
        }
        
        dp[curr][visit] = INF;
        
        for (int i = 0; i < N; i++) {
            int next = visit | (1 << i);
            //경로가 없거나 이미 방문한 경우
            if (data[curr][i] == 0 || (visit & (1 << i)) != 0)
                continue;
            dp[curr][visit] = Math.min(dp[curr][visit], data[curr][i] + tsp(i, next));
        }
        return dp[curr][visit];
    }
}