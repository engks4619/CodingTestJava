import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static List[] graph;
    static int[] edgeCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList();
        }
        edgeCnt = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeCnt[to]++;
            graph[from].add(to);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(edgeCnt[i] == 0) queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(" ");
            List<Integer> nextList = graph[curr];
            for(int next : nextList) {
                edgeCnt[next]--;
                if(edgeCnt[next] == 0) queue.offer(next);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

}