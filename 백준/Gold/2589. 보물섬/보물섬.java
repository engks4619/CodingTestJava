import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxDist;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 'L')
                    go(i, j);
            }
        }
        System.out.println(maxDist);
        in.close();
    }

    static void go(int sR, int sC) {
        visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC, 0});
        visited[sR][sC] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            maxDist = Math.max(maxDist, dist);
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M
                        || visited[nr][nc] || board[nr][nc] != 'L')
                    continue;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, dist + 1});
            }
        }
    }
    
}