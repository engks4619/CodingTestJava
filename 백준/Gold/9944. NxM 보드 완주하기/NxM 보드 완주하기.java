import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M, emptyCnt, minMoveCnt;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final int MAX_CNT = 1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = 1;
        String NMStr;
        while ((NMStr = in.readLine()) != null && !NMStr.isEmpty()) {
            StringTokenizer st = new StringTokenizer(NMStr);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            emptyCnt = 0;
            minMoveCnt = MAX_CNT;
            board = new char[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String str = in.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = str.charAt(j);
                    if(board[i][j] == '.') emptyCnt++;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(board[i][j] == '.') {
                        visited[i][j] = true;
                        go(i, j, 1, 0);
                        visited[i][j] = false;
                    }
                }
            }
            int answer = minMoveCnt == MAX_CNT ? -1 : minMoveCnt;
            bw.write("Case " + TC++ + ": " + answer + "\n");
        }
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int r, int c, int dist, int moveCnt) {
        if(moveCnt > minMoveCnt) return;
        if(dist >= emptyCnt) {
            minMoveCnt = moveCnt;
            return;
        }
        for (int d = 0; d < dr.length; d++) {
            int currDist = 0;
            int nr = r + dr[d];
            int nc = c + dc[d];
            while(nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == '.' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                currDist++;
                nr += dr[d];
                nc += dc[d];
            }
            if(currDist == 0) continue;
            nr -= dr[d];
            nc -= dc[d];
            go(nr, nc, dist + currDist, moveCnt + 1);
            while(currDist-- > 0) {
                visited[nr][nc] = false;
                nr -= dr[d];
                nc -= dc[d];
            }
        }
    }

}