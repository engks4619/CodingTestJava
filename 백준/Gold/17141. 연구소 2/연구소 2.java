import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M, minTime = Integer.MAX_VALUE;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Point> candiList = new ArrayList<>();
    static Point[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        selected = new Point[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                    candiList.add(new Point(i, j));
                }
            }
        }
        dfs(0, 0);
        minTime = minTime == Integer.MAX_VALUE ? -1 : minTime;
        bw.write(minTime + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void dfs(int cnt, int curr) {
        if(cnt == M){
            bfs();
            return;
        }
        for (int i = curr; i < candiList.size(); i++) {
            selected[cnt] = candiList.get(i);
            dfs(cnt + 1, i + 1);
        }

    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] tmpBoard = copyBoard();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            Point p = selected[i];
            queue.offer(new int[] {p.r, p.c, 0});
            visited[p.r][p.c] = true;
            tmpBoard[p.r][p.c] = 1;
        }
        int tmpTime = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];
            tmpTime = Math.max(tmpTime, time);
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || board[nr][nc] != 0) continue;
                visited[nr][nc] = true;
                tmpBoard[nr][nc] = time + 1;
                queue.offer(new int[] {nr, nc, time + 1});
            }

        }
        if (checkBoard(tmpBoard)) minTime = Math.min(minTime, tmpTime);
    }

    static int[][] copyBoard() {
        int[][] tmpBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            tmpBoard[i] = board[i].clone();
        }
        return tmpBoard;
    }

    static boolean checkBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
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