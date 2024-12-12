
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node> nodeList;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList<Node>();
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(from, to, dist));
        }
        Collections.sort(nodeList);
        int sum = 0;
        int lastDist = 0;
        for(Node node : nodeList) {
            if(find(node.from) != find(node.to)){
                sum += node.dist;
                union(node.from, node.to);
                lastDist = node.dist;
            }
        }
        System.out.println(sum - lastDist);
        in.close();
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) parents[y] = x;
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int dist;

        public Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}