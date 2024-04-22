import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while(true) {
            if(getCnt() >= 2) break;
            melt();
            time++;
            if(isEmptyBoard()) {
                time = 0;
                break;
            }
        }
        System.out.println(time);
        in.close();
    }

    static void melt() {
        int[][] tmpBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != 0) {
                    int cnt = 0;
                    for (int d = 0; d < dr.length; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        if(board[nr][nc] == 0) cnt++;
                    }
                    tmpBoard[i][j] = cnt;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = Math.max(board[i][j] - tmpBoard[i][j], 0);
            }
        }
    }

    static int getCnt() {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] != 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M
                    || visited[nr][nc] || board[nr][nc] == 0) continue;
            dfs(nr, nc, visited);
        }
    }

    static boolean isEmptyBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != 0) return false;
            }
        }
        return true;
    }

}