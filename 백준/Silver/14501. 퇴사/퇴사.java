import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static Node[] arr;
    static int[] dp = new int[21];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new Node[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i] = new Node(T, P);
        }
        bw.write(getMaxPoint() + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static int getMaxPoint(){
        for (int i = 1; i <= N; i++) {
            int T = arr[i].getTime();
            int P = arr[i].getPoint();
            dp[i + T] = Math.max(dp[i + T], dp[i] + P);
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        return dp[N + 1];
    }

    static class Node {
        int time;
        int point;

        public Node(int time, int point) {
            this.time = time;
            this.point = point;
        }

        public int getTime() {
            return time;
        }

        public int getPoint() {
            return point;
        }

    }
}