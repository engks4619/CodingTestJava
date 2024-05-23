import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int totalDist;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        visited[1] = true;
        dfs(1, 0);
        System.out.println(totalDist % 2 != 0 ? "Yes" : "No");
        in.close();
    }

    static void dfs(int curr, int dist) {
        for(int next : graph[curr]) {
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next, dist + 1);
        }
        if(curr != 1 && graph[curr].size() == 1)
            totalDist += dist;
    }

}