import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, sR, sC;
    static char[][] board;
    static int[][] heightBoard;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new char[N][N];
        heightBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'P') {
                   sR = i;
                   sC = j;
                }
                else if(board[i][j] == 'K') K++;
            }
        }
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                heightBoard[i][j] = Integer.parseInt(st.nextToken());
                set.add(heightBoard[i][j]);
                if(board[i][j] == 'P' || board[i][j] == 'K'){
                    min = Math.min(min, heightBoard[i][j]);
                    max = Math.max(max, heightBoard[i][j]);
                }
            }
        }
        List<Integer> heightList = new ArrayList<>(set);
        Collections.sort(heightList);
        int l = 0, r = heightList.indexOf(max);
        int minIdx = heightList.indexOf(min);
        int answer = Integer.MAX_VALUE;
        while(l <= minIdx && l <= r && r < heightList.size()) {
            if(bfs(heightList.get(l), heightList.get(r))) {
                answer = Math.min(answer, heightList.get(r) - heightList.get(l));
                l++;
            }
            else r++;
        }
        System.out.println(answer);
        in.close();
    }

    static boolean bfs(int low, int high) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        boolean[][] visited = new boolean[N][N];
        visited[sR][sC] = true;
        int houseCnt = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]
                        || heightBoard[nr][nc] < low || heightBoard[nr][nc] > high) continue;
                if(board[nr][nc] == 'K') houseCnt++;
                if(houseCnt == K) return true;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
        return false;
    }

}