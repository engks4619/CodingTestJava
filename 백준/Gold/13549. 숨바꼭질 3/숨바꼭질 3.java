import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        bw.write(minTime + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        visited[N] = true;
        queue.offer(new int[] {N, 0});
        while(!queue.isEmpty()){
            int[] currNode = queue.poll();
            int curr = currNode[0];
            int time = currNode[1];
            if(curr == K) {
                minTime = time;
                return;
            }
            if(curr * 2 >= 0 && curr * 2 <= 100000 && !visited[curr * 2]) {
                visited[curr * 2] = true;
                queue.offer(new int[] {curr * 2, time});
            }
            if(curr - 1 >= 0 && curr - 1 <= 100000 && !visited[curr - 1]) {
                visited[curr - 1] = true;
                queue.offer(new int[] {curr - 1, time + 1});
            }
            if(curr + 1 >= 0 && curr + 1 <= 100000 && !visited[curr + 1]) {
                visited[curr + 1] = true;
                queue.offer(new int[] {curr + 1, time + 1});
            }
        }
    }

}