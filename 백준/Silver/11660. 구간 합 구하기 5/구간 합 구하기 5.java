import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N + 1][N + 1];
        long[][] sum = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum[1][1] = board[1][1];
        for(int i = 2; i <= N; i++) {
            sum[i][1] = sum[i - 1][1] + board[i][1];
            sum[1][i] = sum[1][i - 1] + board[1][i];
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + board[i][j] - sum[i - 1][j - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int ar = Integer.parseInt(st.nextToken());
            int ac = Integer.parseInt(st.nextToken());
            int br = Integer.parseInt(st.nextToken());
            int bc = Integer.parseInt(st.nextToken());
            long result = sum[br][bc] - sum[ar - 1][bc] - sum[br][ac - 1] + sum[ar - 1][ac - 1];
            sb.append(result).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

}