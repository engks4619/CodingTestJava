import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parents, level;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        parents = new int[N + 1];
        visited = new boolean[N + 1];
        level = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(parents, -1);
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1, 0, 1);
        int M = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a, b)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void dfs(int curr, int depth, int parent) {
        parents[curr] = parent;
        visited[curr] = true;
        level[curr] = depth;
        for(int next : graph[curr]) {
            if(visited[next]) continue;
            dfs(next, depth + 1, curr);
        }
    }

    static int getLCA(int a, int b) {
        if(level[a] > level[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (level[a] != level[b]){
            b = parents[b];
        }
        while(a != b) {
            a = parents[a];
            b = parents[b];
        }
        return a;
    }

}