import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D, minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        bfs();
        bw.write(minCnt == Integer.MAX_VALUE ? "use the stairs" : minCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[F + 1];
        queue.offer(new int[] {S, 0});
        visited[S] = true;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int curr = node[0];
            int cnt = node[1];
            if(curr == G) {
                minCnt = Math.min(minCnt, cnt);
                break;
            }
            if(curr + U <= F && !visited[curr + U]) {
                visited[curr + U] = true;
                queue.offer(new int[] {curr + U, cnt + 1});
            }
            if(curr - D > 0 && !visited[curr - D]) {
                visited[curr - D] = true;
                queue.offer(new int[] {curr - D, cnt + 1});
            }
        }
    }
}