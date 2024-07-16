import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Node> nodePq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodePq.offer(new Node(Math.min(a, b), Math.max(a, b)));
        }
        int D = Integer.parseInt(in.readLine());
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!nodePq.isEmpty()) {
            Node curr = nodePq.poll();
            if(curr.end - curr.start > D) continue;
            pq.offer(curr.start);
            while(!pq.isEmpty()) {
                if(pq.peek() < curr.end - D) pq.poll();
                else break;
            }
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
        in.close();
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.end != o.end ?
                    this.end - o.end : this.start - o.start;
        }
    }
}