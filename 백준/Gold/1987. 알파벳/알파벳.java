import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M, maxCnt;
    static char[][] board;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited;
    static boolean[] isVisitedAlphabet = new boolean['Z' - 'A' + 1];

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
        isVisitedAlphabet[board[0][0] - 'A'] = true;
        visited[0][0] = true;
        dfs(0, 0, 1);
        bw.write(maxCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void dfs(int r, int c, int cnt) {
        maxCnt = Math.max(maxCnt, cnt);
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]
                    || isVisitedAlphabet[board[nr][nc] - 'A']) continue;
            isVisitedAlphabet[board[nr][nc] - 'A'] = true;
            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1);
            isVisitedAlphabet[board[nr][nc] - 'A'] = false;
            visited[nr][nc] = false;
        }
    }

}