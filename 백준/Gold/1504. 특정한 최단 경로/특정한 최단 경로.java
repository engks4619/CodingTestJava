import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, E;
    static List<Node>[] graph;
    static final int INF = (int) 2e8;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, dist));
            graph[b].add(new Node(a, dist));
        }
        st = new StringTokenizer(in.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int dist1 = getDistance(1, v1) + getDistance(v1, v2) + getDistance(v2, N);
        int dist2 = getDistance(1, v2) + getDistance(v2, v1) + getDistance(v1, N);
        int dist = Math.min(dist1, dist2);
        System.out.println(dist < INF ? dist : -1);
        in.close();
    }

    static int getDistance(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        visited[s] = true;
        pq.offer(new Node(s, 0));
        while(!pq.isEmpty()) {
            Node currNode = pq.poll();
            int curr = currNode.dest;
            visited[curr] = true;
            for(Node nextNode : graph[curr]) {
                int next = nextNode.dest;
                if(!visited[next] && dist[next] > dist[curr] + nextNode.dist) {
                    dist[next] = dist[curr] + nextNode.dist;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
        return dist[e];
    }

    static class Node implements Comparable<Node> {
        int dest;
        int dist;

        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    }

}