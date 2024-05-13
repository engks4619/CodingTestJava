import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static boolean[][] board, visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cnt;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new boolean[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    board[r][c] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && !board[i][j]) go(i, j);
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        StringBuilder sb = new StringBuilder();
        for(int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(cnt);
        System.out.println(sb);
        in.close();
    }

    static void go(int r, int c) {
        int area = 1;
        cnt++;
        visited[r][c] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || board[nr][nc]) continue;
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                area++;
            }
        }
        list.add(area);
    }

}