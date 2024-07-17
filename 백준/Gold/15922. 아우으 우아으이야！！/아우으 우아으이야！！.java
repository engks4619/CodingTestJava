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
        int end = Integer.MIN_VALUE;
        int sum = 0;
        for (Node node : list) {
            if(node.end <= end) continue;
            if(end <= node.start) sum += node.end - node.start;
            else sum += node.end - end;
            end = node.end;
        }
        System.out.println(sum);
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
            return start != o.start ?
                    start - o.start : end - o.end;
        }
    }

}