import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, zeroCnt, minTime = Integer.MAX_VALUE;
    static int[][] board;
    static List<Point> inactiveVirusList = new ArrayList<>();
    static Point[] activeVirusArr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        activeVirusArr = new Point[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) inactiveVirusList.add(new Point(i, j));
                else if (board[i][j] == 0) zeroCnt++;
            }
        }
        dfs(0, 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
        in.close();
    }

    static void dfs(int cnt, int curr) {
        if(cnt == M) {
            bfs();
            return;
        }
        for (int i = curr; i < inactiveVirusList.size(); i++) {
            activeVirusArr[cnt] = inactiveVirusList.get(i);
            dfs(cnt + 1, i + 1);
        }
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            Point p = activeVirusArr[i];
            visited[p.r][p.c] = true;
            queue.offer(new int[] {p.r, p.c, 0});
        }
        int maxTime = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N
                        || board[nr][nc] == 1 || visited[nr][nc]) continue;
                if(board[nr][nc] == 0) {
                    cnt++;
                    maxTime = Math.max(maxTime, time + 1);
                }
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, time + 1});
            }
        }
        if (zeroCnt == cnt) minTime = Math.min(minTime, maxTime);
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}