import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        M = 1 << N;
        board = new int[M][M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < Q; i++) {
            int l = Integer.parseInt(st.nextToken());
            divide(l);
            melt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getSum()).append("\n");
        visited = new boolean[M][M];
        int maxArea = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] > 0) {
                    maxArea = Math.max(maxArea, getArea(i, j));
                }
            }
        }
        sb.append(maxArea);
        System.out.println(sb);
        in.close();
    }

    static void divide(int l) {
        int len = 1 << l;
        int[][] tempBoard = new int[M][M];
        for (int i = 0; i < M; i += len) {
            for (int j = 0; j < M; j += len) {
                rotate(i, j, len, tempBoard);
            }
        }
        board = tempBoard;
    }

    static void rotate(int r, int c, int size, int[][] tempBoard) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                tempBoard[i][j] = board[(r + size - 1) - (j - c)][c + (i - r)];
            }
        }
    }

    static void melt() {
        boolean[][] isMelt = new boolean[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 0) continue;
                int cnt = 0;
                for (int d = 0; d < dr.length; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(nr < 0 || nr >= M || nc < 0 || nc >= M || board[nr][nc] == 0) continue;
                    cnt++;
                }
                if(cnt <= 2)
                    isMelt[i][j] = true;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if(isMelt[i][j])
                    board[i][j]--;
            }
        }

    }

    static int getSum() {
        int sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

    static int getArea(int sR, int sC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        visited[sR][sC] = true;
        int area = 1;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= M || nc < 0 || nc >= M || board[nr][nc] == 0 || visited[nr][nc]) continue;
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                area++;
            }
        }
        return area;
    }

}