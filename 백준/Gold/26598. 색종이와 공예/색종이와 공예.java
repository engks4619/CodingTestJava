import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static String YES = "dd";
    final static String NO = "BaboBabo";
    static boolean[][] visited;
    static int N, M;
    static char[][] board;
    static boolean result = true;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    boolean flag = bfs(i, j);
                    if (!flag) {
                        result = false;
                        break outer;
                    }
                }
            }
        }
        System.out.println(result ? YES : NO);
        in.close();
    }

    static boolean bfs(int sR, int sC) {
        char ch = board[sR][sC];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sR, sC});
        int luR = sR, luC = sC, rdR = sR, rdC = sC;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            if (currR < 0 || currR >= N || currC < 0 || currC >= M || ch != board[currR][currC]) continue;
            luR = Math.min(luR, currR);
            luC = Math.min(luC, currC);
            rdR = Math.max(rdR, currR);
            rdC = Math.max(rdC, currC);
            for (int d = 0; d < 4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != ch || visited[nr][nc]) continue;
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        for (int i = luR; i <= rdR; i++) {
            for (int j = luC; j <= rdC; j++) {
                if (board[i][j] != ch)
                    return false;
            }
        }
        return true;
    }
}