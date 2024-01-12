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
        visited[0][0][0] = true;
        queue.offer(new Point(0, 0, 0, 1));
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            if(curr.r == N - 1 && curr.c == M - 1)
                minDist = Math.min(minDist, curr.dist);
            for (int d = 0; d < dr.length; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M
                        || visited[nr][nc][curr.k]) continue;
                if(curr.k < K) {
                    visited[nr][nc][curr.k + 1] = true;
                    queue.offer(new Point(nr, nc, curr.k + 1, curr.dist + 1));
                }
                if(board[nr][nc] != 0) continue;
                visited[nr][nc][curr.k] = true;
                queue.offer(new Point(nr, nc, curr.k, curr.dist + 1));
            }
        }
    }

    static class Point {
        int r;
        int c;
        int k;
        int dist;

        public Point(int r, int c, int k, int dist) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = dist;
        }
    }
}