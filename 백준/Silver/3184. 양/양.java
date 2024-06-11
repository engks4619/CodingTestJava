import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int sheepCnt, wolfCnt;
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
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != '#' && !visited[i][j])
                    go(i, j);
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
        in.close();
    }

    static void go(int sR, int sC) {
        int sCnt = 0;
        int wCnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        visited[sR][sC] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if(board[r][c] == 'o') sCnt++;
            else if(board[r][c] == 'v') wCnt++;
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || board[nr][nc] == '#')
                    continue;
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        if(sCnt > wCnt) sheepCnt += sCnt;
        else wolfCnt += wCnt;
    }

}