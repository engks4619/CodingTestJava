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

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Node node : list) {
            if(!pq.isEmpty() && pq.peek() <= node.s) pq.poll();
            pq.offer(node.e);
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
        in.close();
    }

    static class Node implements Comparable<Node> {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o) {
            return s != o.s ? s - o.s : e - o.e;
        }
    }

}