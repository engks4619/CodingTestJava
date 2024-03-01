import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board, distBoard;
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        distBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distBoard[i], N * M + 1);
        }
        Queue<int[]> sharkQueue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) sharkQueue.offer(new int[] {i, j});
            }
        }

        while(!sharkQueue.isEmpty()) {
            int[] shark = sharkQueue.poll();
            bfs(shark[0], shark[1]);
        }

        bw.write(getMaxDist() + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs(int sR, int sC) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[] {sR, sC, 0});
        visited[sR][sC] = true;
        distBoard[sR][sC] = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || board[nr][nc] != 0 || distBoard[nr][nc] < dist + 1) continue;
                visited[nr][nc] = true;
                distBoard[nr][nc] = Math.min(distBoard[nr][nc], dist + 1);
                queue.offer(new int[] {nr, nc, dist + 1});
            }
        }
    }

    static int getMaxDist() {
        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDist = Math.max(maxDist, distBoard[i][j]);
            }
        }
        return maxDist;
    }
}