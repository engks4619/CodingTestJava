import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static boolean[][] boardA, boardB;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boardA = initBoard(in);
        boardB = initBoard(in);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(boardA[i][j] != boardB[i][j]) {
                    flipBoard(i, j, 3);
                }
            }
        }
        bw.write(isBoardSame() ? cnt + "\n" : "-1\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean[][] initBoard(BufferedReader in) throws Exception {
        boolean[][] board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0' == 1 ? true : false;
            }
        }
        return board;
    }

    static void flipBoard(int r, int c, int size) {
        if(r + size > N || c + size > M) return;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                boardA[i][j] = !boardA[i][j];
            }
        }
        cnt++;
    }

    static boolean isBoardSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(boardA[i][j] != boardB[i][j]) return false;
            }
        }
        return true;
    }

}