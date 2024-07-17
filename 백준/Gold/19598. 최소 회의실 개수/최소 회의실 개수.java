import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<Node> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e));
        }

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Node node : list) {
            if(!pq.isEmpty() && pq.peek() <= node.start) pq.poll();
            pq.offer(node.end);
        }

        System.out.println(pq.size());
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
            return this.start != o.start ?
                    this.start - o.start : this.end - o.end;
        }
    }
}