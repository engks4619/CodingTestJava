import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, roomNum = 0, maxRoomCnt, maxBreakableRoomCnt;
    static int[][] board, room;
    static boolean[][] visited;
    static Map<Integer, Integer> areaMap = new HashMap<>();
    static int[] dr = {0, -1, 0, 1}; // 서 북 동 남
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        room = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(room[i][j] == 0)
                    bfs(i, j, ++roomNum);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j])
                    updateMaxBreakableRoomCnt(i, j);
            }
        }
        System.out.println(roomNum);
        System.out.println(maxRoomCnt);
        System.out.println(maxBreakableRoomCnt);
        in.close();
    }

    static void updateMaxBreakableRoomCnt(int sR, int sC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC, room[sR][sC]});
        visited[sR][sC] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int roomNum = curr[2];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                int nRoomNum = room[nr][nc];
                if(roomNum != nRoomNum)
                    maxBreakableRoomCnt = Math.max(maxBreakableRoomCnt,
                            areaMap.get(roomNum) + areaMap.get(nRoomNum));
                queue.offer(new int[] {nr, nc, nRoomNum});
            }
        }
    }

    static void bfs(int sR, int sC, int roomNum) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        room[sR][sC] = roomNum;
        int roomCnt = 1;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                if((board[r][c] & 1 << d) != 0) continue;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || room[nr][nc] != 0) continue;
                room[nr][nc] = roomNum;
                roomCnt++;
                queue.offer(new int[] {nr, nc});
            }
        }
        areaMap.put(roomNum, roomCnt);
        maxRoomCnt = Math.max(maxRoomCnt, roomCnt);
    }

}