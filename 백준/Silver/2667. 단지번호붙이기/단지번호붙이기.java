import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {

    static int N, num;
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
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        ArrayList<Integer> cntList = new ArrayList<>();
        num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] || board[i][j] == 0) continue;
                int cnt = bfs(i, j, num);
                if(cnt != 0) {
                    cntList.add(cnt);
                    num++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num).append("\n");
        Collections.sort(cntList);
        cntList.forEach((num) -> sb.append(num).append("\n"));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static int bfs(int sR, int sC, int num){
        int cnt = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        board[sR][sC] += num;
        visited[sR][sC] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || board[nr][nc] != 1) continue;
                cnt++;
                board[nr][nc] += num;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
        return cnt;
    }

}