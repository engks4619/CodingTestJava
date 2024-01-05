import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        go(N);
        int minTime = time[K];
        StringBuilder sb = new StringBuilder();
        sb.append(minTime).append("\n");
        Stack<Integer> stack = new Stack<>();
        int idx = K;
        while(true){
            if(idx == N){
                stack.push(idx);
                break;
            }
            stack.push(idx);
            idx = parent[idx];
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();

            if(curr == K) return;

            for(int next : new int[] {curr + 1, curr - 1, 2 * curr}){
                if(next < 0 || next > 100000 || visited[next]) continue;
                visited[next] = true;
                time[next] = time[curr] + 1;
                parent[next] = curr;
                queue.offer(next);
            }
        }
        return;
    }

}