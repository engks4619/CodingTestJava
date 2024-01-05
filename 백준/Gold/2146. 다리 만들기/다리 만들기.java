import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, minDistance = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        numberingIslands();
        updateMinDistance();
        bw.write(minDistance + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void numberingIslands(){
        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 1) bfs(i, j, num++);
            }
        }
    }

    static void updateMinDistance(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] != 0){
                    minDistance = Math.min(minDistance, getDistance(i, j));
                }
            }
        }
    }

    static int getDistance(int sR, int sC){
        int num = board[sR][sC];
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][N];
        visited[sR][sC] = true;
        queue.offer(new int[] {sR, sC, 0});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            if(board[r][c] != 0 && board[r][c] != num) return dist - 1;
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N
                        || visited[nr][nc] || board[nr][nc] == num) continue;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, dist + 1});
            }
        }
        return Integer.MAX_VALUE;
    }

    static void bfs(int sR, int sC, int num){
        Queue<int[]> queue = new ArrayDeque<>();
        board[sR][sC] = num;
        queue.offer(new int[] {sR, sC});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != 1) continue;
                board[nr][nc] = num;
                queue.offer(new int[] {nr, nc});
            }
        }
    }
}