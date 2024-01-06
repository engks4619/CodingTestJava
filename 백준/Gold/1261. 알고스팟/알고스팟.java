import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, minCnt = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][10001];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(N - 1, M - 1, 0);
        bw.write(minCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs(int sR, int sC, int sCnt){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(sR, sC, sCnt));
        visited[sR][sC][sCnt] = true;

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int r = curr.r;
            int c = curr.c;
            int cnt = curr.cnt;

            if(r == 0 && c == 0) minCnt = Math.min(minCnt, cnt);

            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || cnt > N + M) continue;
                if(board[nr][nc] != 0 && !visited[nr][nc][cnt + 1]){
                    visited[nr][nc][cnt + 1] = true;
                    queue.offer(new Node(nr, nc, cnt + 1));
                }
                if(board[nr][nc] == 0 && !visited[nr][nc][cnt]){
                    visited[nr][nc][cnt] = true;
                    queue.offer(new Node(nr, nc, cnt));
                }
            }
        }
        return;
    }

    static class Node{
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

}