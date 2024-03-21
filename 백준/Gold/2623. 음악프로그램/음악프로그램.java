import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                inDegree[to]++;
                from = to;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            answer.add(curr);
            for(int next : list[curr]) {
                inDegree[next]--;
                if(inDegree[next] == 0) queue.offer(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(answer.size() == N) {
            for(int num : answer) sb.append(num).append("\n");
        }
        else sb.append(0);
        System.out.print(sb);
        in.close();
    }

}