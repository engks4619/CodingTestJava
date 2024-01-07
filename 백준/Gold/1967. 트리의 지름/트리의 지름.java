import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance, maxNode;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            tree[from].add(new Node(to, dist));
            tree[to].add(new Node(from, dist));
        }
        dfs(1, 0);
        visited = new boolean[N + 1];
        dfs(maxNode, 0);
        bw.write(maxDistance + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void dfs(int node, int dist){
        visited[node] = true;
        if(dist > maxDistance){
            maxDistance = dist;
            maxNode = node;
        }
        for(Node next : tree[node]){
            if(visited[next.idx]) continue;
            dfs(next.idx, dist + next.dist);
        }
    }

    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}