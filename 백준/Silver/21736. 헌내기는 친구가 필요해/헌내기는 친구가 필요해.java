import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int sR = 0, sC = 0;
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'I'){
                    sR = i;
                    sC = j;
                    board[i][j] = 'O';
                }
            }
        }
        go(sR, sC);
        System.out.println(answer == 0 ? "TT" : answer);
        in.close();
    }


    static void go(int sR, int sC){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        visited[sR][sC] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || board[nr][nc] == 'X') continue;
                visited[nr][nc] = true;
                if(board[nr][nc] == 'P') answer++;
                queue.offer(new int[] {nr, nc});
            }

        }
    }
}