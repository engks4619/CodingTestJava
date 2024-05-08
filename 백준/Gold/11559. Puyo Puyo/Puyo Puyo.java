import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N = 12, M = 6, cnt;
    static char[][] board = new char[N][M];
    static boolean[][] visited = new boolean[N][M];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int combo;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        while(goPang()) {
            combo++;
            moveDown();
        }
        System.out.println(combo);
        in.close();
    }

    static void moveDown() {
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i > 0; i--) {
                if(board[i][j] != '.') continue;
                for (int k = i - 1; k >= 0; k--) {
                    if(board[k][j] != '.') {
                        char tmp = board[k][j];
                        board[k][j] = board[i][j];
                        board[i][j] = tmp;
                        break;
                    }
                }
            }
        }
    }

    static boolean goPang() {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != '.' && !visited[i][j]) {
                    cnt = 0;
                    visited = new boolean[N][M];
                    checkPang(i, j, board[i][j]);
                    if(cnt >= 4) {
                        pang();
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    static void pang() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) board[i][j] = '.';
            }
        }
    }
    static void checkPang(int r, int c, char ch) {
        visited[r][c] = true;
        cnt++;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != ch || visited[nr][nc]) continue;
            checkPang(nr, nc, ch);
        }
    }
}