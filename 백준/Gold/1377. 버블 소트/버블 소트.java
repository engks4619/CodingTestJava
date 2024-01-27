import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(Integer.parseInt(in.readLine()), i);
        }
        Arrays.sort(nodes, 1, N + 1);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, nodes[i].idx - i);
        }
        bw.write(max + 1  + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static class Node implements Comparable<Node>{
        int num, idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }


        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }
}