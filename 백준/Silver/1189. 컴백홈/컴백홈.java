import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, answer;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = in.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        visited[R - 1][0] = true;
        go(R - 1, 0, 1);
        System.out.println(answer);
        in.close();
    }

    static void go(int r, int c, int dist) {
        if(dist > K) return;
        if(r == 0 && c == C - 1) {
            if(dist == K) answer++;
            return;
        }
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || board[nr][nc] != '.') continue;
            visited[nr][nc] = true;
            go(nr, nc, dist + 1);
            visited[nr][nc] = false;
        }
    }

}