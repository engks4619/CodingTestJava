import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, dirtyCnt;
    static char[][] board;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0) break;
            board = new char[N][M];
            int sR = -1, sC = -1;
            dirtyCnt = 0;
            for (int i = 0; i < N; i++) {
                String str = in.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = str.charAt(j);
                    if(board[i][j] == 'o') {
                      sR = i;
                      sC = j;
                      board[i][j] = '.';
                    } else if (board[i][j] == '*') {
                        board[i][j] = (char) ('0' + dirtyCnt++);
                    }
                }
            }
            visited = new boolean[N][M][1 << dirtyCnt];
            sb.append(go(sR, sC)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static int go(int sR, int sC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC, 0, 0});
        visited[sR][sC][0] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            int state = curr[3];
            if(state == (1 << dirtyCnt) - 1) return dist;

            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M
                        || visited[nr][nc][state] || board[nr][nc] == 'x') continue;
                if('0' <= board[nr][nc] && board[nr][nc] <= '9') {
                    int nextState = state | (1 << (board[nr][nc] - '0'));
                    if(visited[nr][nc][nextState]) continue;
                    visited[nr][nc][nextState] = true;
                    queue.offer(new int[] {nr, nc, dist + 1, nextState});
                    continue;
                }
                visited[nr][nc][state] = true;
                queue.offer(new int[] {nr, nc, dist + 1, state});
            }
        }

        return -1;
    }

}