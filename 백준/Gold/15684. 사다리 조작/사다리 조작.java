import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int R, M, C, minCnt = Integer.MAX_VALUE;
    static boolean[][] board;
    static boolean isSolved = false;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new boolean[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = true;
        }
        go(1, 1, 0);
        int answer = isSolved ? minCnt : -1;
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int r, int c, int cnt) {
        if(cnt > 3 || minCnt <= cnt) return;
        if(checkNumSolved()) {
            isSolved = true;
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        int j = c;
        for (int i = r; i <= R; i++) {
            if(i != r) j = 1;
            for (; j < C; j++) {
                if(board[i][j] || board[i][j - 1]) continue;
                board[i][j] = true;
                go(i, j, cnt + 1);
                board[i][j] = false;
            }
        }
    }

    static boolean checkNumSolved() {
        for (int c = 1; c <= C; c++) {
            int num = c;
            for (int r = 1; r <= R; r++) {
                if(board[r][num - 1]) num--;
                else if(board[r][num]) num++;
            }
            if(num != c) return false;
        }
        return true;
    }

}