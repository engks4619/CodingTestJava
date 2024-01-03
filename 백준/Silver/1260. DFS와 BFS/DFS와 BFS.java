import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        dfs(V, new boolean[N + 1]);
        sb.append("\n");
        bfs(V);
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void dfs(int idx, boolean[] visited){
        if(visited[idx]) return;
        visited[idx] = true;
        sb.append(idx).append(" ");
        for(int next : list[idx]){
            if(visited[next]) continue;
            dfs(next, visited);
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            sb.append(curr).append(" ");
            for(int next : list[curr]){
                if(visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }
    }

}