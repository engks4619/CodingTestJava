import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Node> queue = new ArrayDeque<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.priority - o1.priority);

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(in.readLine());
        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                Node node = new Node(i, priority);
                queue.offer(node);
                pq.offer(node);
            }
            int time = 0;
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                if(node.priority < pq.peek().priority) {
                    queue.offer(node);
                    continue;
                }
                time++;
                pq.poll();
                if(node.idx == idx) break;
            }
            sb.append(time).append("\n");
            queue.clear();
            pq.clear();
        }
        System.out.print(sb);
        in.close();
    }

    static class Node {
        int idx;
        int priority;

        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

}