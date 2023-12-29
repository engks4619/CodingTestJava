import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                go(i, j);
            }
        }
        System.out.println(maxCnt);
        in.close();
    }

    static void go(int sR, int sC){
        for (int d = 0; d < 4; d++) {
            int nr = sR + dr[d];
            int nc = sC + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(board[sR][sC] != board[nr][nc]){
                swapChar(sR, sC, nr, nc);
                updateMaxCnt();
                swapChar(nr, nc, sR, sC);
            }
        }
    }

    static void updateMaxCnt(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int curr = board[i][j];
                for (int d = 0; d < 4; d++) {
                    int cnt = 1;
                    int nr = i;
                    int nc = j;
                    while(true){
                        nr += dr[d];
                        nc += dc[d];
                        if(nr < 0 || nr >= N || nc < 0 || nc >= N || curr != board[nr][nc]) break;
                        cnt++;
                    }
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }
    }

    static void swapChar(int r, int c, int nr, int nc){
        char tmp = board[r][c];
        board[r][c] = board[nr][nc];
        board[nr][nc] = tmp;
    }
}