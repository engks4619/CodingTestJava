import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
        in.close();
    }

    static void dfs(int curr) {
        visited[curr] = true;
        dp[curr][0] = 0;
        dp[curr][1] = 1;
        for(int next : graph[curr]) {
            if(visited[next]) continue;
            dfs(next);
            dp[curr][0] += dp[next][1];
            dp[curr][1] += Math.min(dp[next][1], dp[next][0]);
        }
    }

}