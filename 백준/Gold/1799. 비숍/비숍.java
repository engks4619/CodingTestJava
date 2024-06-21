import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, maxCnt;
    static int[][] board;
    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {-1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;
        go(0, 0, 0, visited, 'B');
        cnt += maxCnt;
        visited = new boolean[N][N];
        maxCnt = 0;
        go(0, 1, 0,  visited, 'W');
        cnt += maxCnt;
        System.out.println(cnt);
        in.close();
    }

    static void go(int r, int c, int cnt, boolean[][] visited, char type) {
        maxCnt = Math.max(maxCnt, cnt);
        if(c >= N) {
            r++;
            if(type == 'B') c = r % 2 != 0 ? 1 : 0;
            else c = r % 2 != 0 ? 0 : 1;
        }
        if(r >= N) return;

        if(isPossible(r, c, visited)){
            visited[r][c] = true;
            go(r, c + 2, cnt + 1, visited, type);
            visited[r][c] = false;
        }
        go(r, c + 2, cnt, visited, type);
    }

    static boolean isPossible(int r, int c, boolean[][] visited) {
        if(board[r][c] == 0) return false;
        for (int d = 0; d < dr.length; d++) {
            int nr = r;
            int nc = c;
            for (int i = 0; i < N; i++) {
                nr += dr[d];
                nc += dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) return false;
            }
        }
        return true;
    }

}