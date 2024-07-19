import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s > e) list.add(new Node(s, e));
        }
        Collections.sort(list);
        long dist = 0;
        long max = 0;
        for(Node node : list) {
            if(node.right <= max) continue;
            if(max <= node.left) dist += node.right - node.left;
            else dist += node.right - max;
            max = node.right;
        }
        dist = dist * 2 + M;
        System.out.println(dist);
        in.close();
    }

    static class Node implements Comparable<Node> {
        int right;
        int left;

        public Node(int right, int left) {
            this.right = right;
            this.left = left;
        }

        @Override
        public int compareTo(Node o) {
            return left != o.left ?
                    left - o.left : right - o.right;
        }
    }

}