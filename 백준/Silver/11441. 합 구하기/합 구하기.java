import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            sum[i + 1] = Integer.parseInt(st.nextToken()) + sum[i];
        }
        int M = Integer.parseInt(in.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(sum[r] - sum[l - 1]).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}