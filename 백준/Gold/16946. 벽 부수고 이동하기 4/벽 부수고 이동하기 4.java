import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static Point[][] pointBoard;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        pointBoard = new Point[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] == 0) {
                    bfs(i, j, num++);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1) updateCnt(i, j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs(int sr, int sc, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> visitedQueue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        visitedQueue.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M
                        || visited[nr][nc] || board[nr][nc] != 0) continue;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
                visitedQueue.offer(new int[] {nr, nc});
            }
        }
        int cnt = visitedQueue.size();
        while(!visitedQueue.isEmpty()){
            int[] pos = visitedQueue.poll();
            int r = pos[0];
            int c = pos[1];
            pointBoard[r][c] = new Point(num, r, c, cnt);
        }
    }

    static void updateCnt(int r, int c) {
        Set<Integer> numSet = new HashSet<>();
        int cnt = 1;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != 0) continue;
            Point point = pointBoard[nr][nc];
            if(point == null || numSet.contains(point.num)) continue;
            numSet.add(point.num);
            cnt += point.cnt;
        }
        board[r][c] = cnt % 10;
    }

    static class Point {
        int num;
        int r;
        int c;
        int cnt;

        public Point(int num, int r, int c, int cnt) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

}