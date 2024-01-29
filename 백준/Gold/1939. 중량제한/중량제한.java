import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static List<Node>[] list;
    static int  N, M, start, end;
    static long answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        long max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            max = Math.max(max, w);
            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }
        st = new StringTokenizer(in.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        go(1, max);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(long left, long right) {
        while(left <= right) {
            long mid = (left + right) / 2;
            if(bfs(mid)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
            else right = mid - 1;
        }
    }

    static boolean bfs(long maxWeight) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == end) return true;
            for (Node next : list[curr]) {
                if(!visited[next.dest] && next.weight >= maxWeight) {
                    visited[next.dest] = true;
                    queue.offer(next.dest);
                }
            }
        }
        return false;
    }

    static class Node {
        int dest, weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

}