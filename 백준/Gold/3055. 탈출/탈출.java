import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, minTime = Integer.MAX_VALUE;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sr, sc, er, ec;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'S') {
                    sr = i;
                    sc = j;
                    board[i][j] = '.';
                }
                if(board[i][j] == 'D') {
                    er = i;
                    ec = j;
                    board[i][j] = '.';
                }
            }
        }
        bw.write(bfs() ? minTime + "\n" : "KAKTUS");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        int cnt = 0;
        while(!queue.isEmpty()) {
            moveWater();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                if(r == er && c == ec) {
                    minTime = cnt;
                    return true;
                }
                for (int d = 0; d < dr.length; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M
                            || visited[nr][nc] || board[nr][nc] != '.') continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
            cnt++;
        }
        return false;
    }

    static void moveWater() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == '*') {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M
                        || (nr == er && nc == ec) || board[nr][nc] == 'X') continue;
                board[nr][nc] = '*';
            }
        }
    }

}