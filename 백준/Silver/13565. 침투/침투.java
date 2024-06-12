import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean answer = false;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new boolean[N + 1][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) == '1';
            }
        }
        for (int i = 0; i < M; i++) {
            if(!board[0][i] && go(0, i)) {
                answer = true;
                break;
            }
        }

        System.out.println(answer ? "YES" : "NO");
        in.close();
    }

    static boolean go(int sR, int sC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        boolean[][] visited = new boolean[N + 1][M];
        visited[sR][sC] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if(r == N) return true;
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N + 1 || nc < 0 || nc >= M || visited[nr][nc] || board[nr][nc])
                    continue;
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        return false;
    }
}