import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, maxCnt;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        go(0, 0, 0);
        bw.write(maxCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int r, int c, int cnt) {
        if(cnt == 2) {
            updateMaxCnt();
            return;
        }
        for (int i = r; i < N; i++) {
            for (int j = 0; j < M; j++) {
               if(board[i][j] != 0) continue;
               board[i][j] = 1;
               go(i, j, cnt + 1);
               board[i][j] = 0;
            }
        }
    }

    static void updateMaxCnt() {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 2 && !visited[i][j]) cnt += bfs(i, j, visited);
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
    }

    static int bfs(int r, int c, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        int cnt = 1;
        boolean isEmpty = false;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || board[nr][nc] == 1) continue;
                if(board[nr][nc] == 0) {
                    isEmpty = true;
                    continue;
                }
                visited[nr][nc] = true;
                cnt++;
                queue.offer(new int[] {nr, nc});
            }
        }
        return isEmpty ? 0 : cnt;
    }
}