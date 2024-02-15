import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M, maxArea = 1;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        go(0, 1);
        bw.write(maxArea + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int crossCnt, int area) {
        if(crossCnt == 2){
            maxArea = Math.max(maxArea, area);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != '#') continue;
                for (int size = 0; size <= 7; size++) {
                    if(!isPossible(i, j, size)) break;
                    goVisited(i, j, size, true);
                    go(crossCnt + 1, area * (size * 4 + 1));
                    goVisited(i, j, size, false);
                }
            }
        }

    }

    static void goVisited(int r, int c, int size, boolean flag) {
        for (int d = 0; d < dr.length; d++) {
            for (int i = 0; i <= size; i++) {
                int nr = r + dr[d] * i;
                int nc = c + dc[d] * i;
                visited[nr][nc] = flag;
            }
        }
    }

    static boolean isPossible(int r, int c, int size) {
        if(!isRange(r, c) || visited[r][c] || board[r][c] != '#') return false;
        for (int d = 0; d < dr.length; d++) {
            for (int i = 1; i <= size ; i++) {
                int nr = r + dr[d] * i;
                int nc = c + dc[d] * i;
                if(!isRange(nr, nc) || visited[nr][nc] || board[nr][nc] != '#') return false;
            }
        }
        return true;
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}