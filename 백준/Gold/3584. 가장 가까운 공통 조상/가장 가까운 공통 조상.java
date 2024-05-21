import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] level;
    static int[] parents;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(in.readLine());
            level = new int[N + 1];
            visited = new boolean[N + 1];
            parents = new int[N + 1];
            graph = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            int cnt[] = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
                cnt[b]++;
            }
            int root = -1;
            for (int i = 1; i <= N; i++) {
                if(cnt[i] == 0) {
                    root = i;
                    break;
                }
            }
            dfs(root, 0);
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a, b)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void dfs(int curr, int l){
        visited[curr] = true;
        level[curr] = l;
        for(int next : graph[curr]) {
            if(visited[next]) continue;
            parents[next] = curr;
            dfs(next, l + 1);
        }
    }

    static int getLCA(int a, int b) {
        if(level[a] > level[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        while(level[a] != level[b]) {
            b = parents[b];
        }

        while(a != b) {
            a = parents[a];
            b = parents[b];
        }
        return a;
    }
}