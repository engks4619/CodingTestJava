import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        board = new char[N][N];
        go(0, 0, N, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int r, int c, int size, int cnt) {
        if(cnt == 5) {
            for (int i = r; i < r + size; i++) {
                for (int j = c; j < c + size; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }
        if(size == 1) {
            board[r][c] = '*';
            return;
        }

        int nCnt = 0;
        for (int i = r; i < r + size; i += size / 3) {
            for (int j = c; j < c + size; j += size / 3) {
                go(i, j, size / 3, ++nCnt);
            }
        }
    }

}