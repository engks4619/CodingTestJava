import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int N = 8;
    static char[][] board = new char[N][N];
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1, 0};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        int answer = bfs() ? 1 : 0;
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new int[] {N - 1, 0});
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                if(isCharacterStuck(r, c)) continue;
                if(r == 0 && c == N - 1) return true;
                for (int d = 0; d < dr.length; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N
                            || visited[nr][nc] || board[nr][nc] != '.') continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
            moveWallDown();
            visited = new boolean[N][N];
        }
        return false;
    }


    static boolean isCharacterStuck(int r, int c) {
        return board[r][c] == '#';
    }

    static void moveWallDown() {
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < N; j++) {
                board[i][j] = board[i - 1][j];
            }
        }
        Arrays.fill(board[0], '.');
    }
}