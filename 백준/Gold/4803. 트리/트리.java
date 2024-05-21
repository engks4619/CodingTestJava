import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            graph = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[N + 1];
            int[] indegree = new int[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
                indegree[b]++;
            }
            int treeCnt = 0;
            for (int i = 1; i <= N; i++) {
                if(indegree[i] == 0 && !visited[i]) {
                    if(dfs(i, -1)) treeCnt++;
                }
            }

            sb.append("Case " + T++ + ": ");
            if(treeCnt == 0)
                sb.append("No trees.");
            else if(treeCnt == 1)
                sb.append("There is one tree.");
            else
                sb.append("A forest of " + treeCnt + " trees.");
            sb.append("\n");
        }

        System.out.print(sb);
        in.close();
    }

    static boolean dfs(int curr, int root) {
        for(int next : graph[curr]) {
            if(next == root) continue;
            if(visited[next]) return false;
            visited[next] = true;
            if(!dfs(next, curr)) return false;
        }
        return true;
    }

}