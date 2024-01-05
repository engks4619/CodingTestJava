import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bw.write(go(N) + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static int go(int start){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        visited[start] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int point = curr[0];
            int time = curr[1];
            if(point == K) return time;
            for(int next : new int[] {point + 1, point - 1, 2 * point}){
                if(next < 0 || next > 100000 || visited[next]) continue;
                visited[next] = true;
                queue.offer(new int[] {next, time + 1});
            }
        }
        return Integer.MAX_VALUE;
    }
    
}