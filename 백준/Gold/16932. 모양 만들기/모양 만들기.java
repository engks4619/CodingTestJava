import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static Map<Integer, Integer> cntMap = new HashMap<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        Queue<int[]> zeroQueue = new ArrayDeque<>();
        Queue<int[]> oneQueue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) zeroQueue.offer(new int[] {i, j});
            }
        }

        int num = 2;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1) colorBoard(i, j, num++);
            }
        }

        int maxCnt = 1;
        while(!zeroQueue.isEmpty()) {
            int[] curr = zeroQueue.poll();
            maxCnt = Math.max(maxCnt, getNewCnt(curr[0], curr[1]));
        }

        System.out.println(maxCnt);
        in.close();
    }

    static int getNewCnt(int r, int c) {
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            int num = board[nr][nc];
            if(num == 0 || set.contains(num)) continue;
            set.add(num);
            cnt += cntMap.get(num);
        }
        return cnt;
    }

    static void colorBoard(int r, int c, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        board[r][c] = num;
        int cnt = 1;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != 1) continue;
                board[nr][nc] = num;
                cnt++;
                queue.offer(new int[] {nr, nc});
            }
        }
        cntMap.put(num, cnt);
    }

}