import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, minCnt = Integer.MAX_VALUE;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) == 'H';
            }
        }
        for (int i = 0; i < (1 << N); i++) {
            go(i);
        }
        bw.write(minCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int bit) {
        int sum = 0;
        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = board[i][j];
                if((bit & (1 << i)) != 0)  flag = !flag;
                if(!flag) cnt++;
            }
            sum += Math.min(cnt, N - cnt);
        }
        minCnt = Math.min(minCnt, sum);
    }

}