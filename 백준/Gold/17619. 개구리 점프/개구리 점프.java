import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(i, s, e, y));
        }
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Node left = list.get(i);
                Node right = list.get(j);
                if(right.start <= left.end) union(left.idx, right.idx);
                else break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(Q-- > 0) {
            st = new StringTokenizer(in.readLine());
            int rootA = find(Integer.parseInt(st.nextToken()));
            int rootB = find(Integer.parseInt(st.nextToken()));
            sb.append(rootA == rootB ? 1 : 0).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        return find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a <= b) parent[b] = a;
        else parent[a] = b;
    }

    static class Node implements Comparable<Node> {
        int idx;
        int start;
        int end;
        int y;

        public Node(int idx, int start, int end, int y) {
            this.idx = idx;
            this.start = start;
            this.end = end;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return start != o.start ?
                    start - o.start : end - o.end;
        }
    }

}