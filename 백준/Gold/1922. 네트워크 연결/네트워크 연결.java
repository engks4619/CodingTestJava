import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge> edgeList;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        edgeList = new ArrayList<>();
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        int M = Integer.parseInt(in.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a, b, c));
        }
        Collections.sort(edgeList);

        int cost = 0;
        for (Edge edge : edgeList) {
            if(find(edge.s) == find(edge.e)) continue;
            cost += edge.cost;
            union(edge.s, edge.e);
        }

        System.out.println(cost);
        in.close();
    }

    static int find(int a) {
        if(parents[a] == a) return a;
        return find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parents[b] = a;
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

}