import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        pq.offer(new Node(1, 0));
        int totalDistance = 0;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(visited[curr.to]) continue;
            visited[curr.to] = true;
            totalDistance += curr.dist;
            for(Node next : graph[curr.to]) {
                if(!visited[next.to]) pq.offer(next);
            }
        }

        bw.write(totalDistance + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static class Node implements Comparable<Node> {
        int to;
        int dist;

        public Node( int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

}