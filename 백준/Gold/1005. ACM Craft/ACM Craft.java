import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new List[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] edgeCnt = new int[N + 1];
            int[] timeArr = new int[N + 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= N; i++) {
                timeArr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edgeCnt[to]++;
                graph[from].add(to);
            }
            int W = Integer.parseInt(in.readLine());
            int minTime = getMinTime(N, timeArr, edgeCnt, graph, W);
            sb.append(minTime).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static int getMinTime(int N, int[] timeArr, int[] edgeCnt, List<Integer>[] graph, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] timeDp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            timeDp[i] = timeArr[i];
            if(edgeCnt[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : graph[curr]) {
                timeDp[next] = Math.max(timeDp[next], timeDp[curr] + timeArr[next]);
                edgeCnt[next]--;
                if(edgeCnt[next] == 0) queue.offer(next);
            }
        }
        return timeDp[target];
    }

}