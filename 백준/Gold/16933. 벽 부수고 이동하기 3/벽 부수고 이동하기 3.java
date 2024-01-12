import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, minDist = Integer.MAX_VALUE;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        bw.write(minDist == Integer.MAX_VALUE ? -1 + "\n" : minDist + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][K + 1];
        queue.offer(new Point(0, 0, 1, 0, true));
        visited[0][0][0] = true;
        int time = 0;
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            int nDay = !curr.isBreakable ? 1 : 0;
            if(curr.r == N - 1 && curr.c == M - 1) {
                minDist = Math.min(minDist, curr.dist);
                return;
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(board[nr][nc] == 0 && !visited[nr][nc][curr.k]){
                    visited[nr][nc][curr.k] = true;
                    queue.offer(new Point(nr, nc, curr.dist + 1, curr.k, !curr.isBreakable));
                }
                if(board[nr][nc] == 1 && curr.k < K) {
                    //벽 부수고 가는경우
                    if(curr.isBreakable && !visited[nr][nc][curr.k + 1]) {
                        visited[nr][nc][curr.k + 1] = true;
                        queue.offer(new Point(nr, nc, curr.dist + 1, curr.k + 1, !curr.isBreakable));
                    }
                    //밤이라 벽을 못부수는 경우 제자리로 보내기
                    else if(!curr.isBreakable && !visited[nr][nc][curr.k + 1]) {
                        queue.offer(new Point(curr.r, curr.c, curr.dist + 1, curr.k, !curr.isBreakable));
                    }
                }
            }
        }
    }

    static class Point {
        int r, c, dist, k;
        boolean isBreakable;

        public Point(int r, int c, int dist, int k, boolean isBreakable) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.k = k;
            this.isBreakable = isBreakable;
        }
    }
}