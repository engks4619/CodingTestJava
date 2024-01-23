import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        board = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }
        go(0, N - 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int r, int c, int size) {
        if(size == 3) {
            for (int i = r; i < r + 3; i++) {
                int row = i - r;
                for (int j = c - row; j <= c + row; j++) {
                    // col = c - j
                    if(row == 1 && c - j == 0) continue;
                    board[i][j] = '*';
                }
            }
            return;
        }
        int nSize = size / 2;
        go(r, c, nSize);
        go(r + nSize, c - nSize, nSize);
        go(r + nSize, c + nSize, nSize);
    }

}