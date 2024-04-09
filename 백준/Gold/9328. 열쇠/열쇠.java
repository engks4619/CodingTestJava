import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] board;
    static boolean[] keyArr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(in.readLine());
        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cnt = 0;
            board = new char[N][M];
            keyArr = new boolean[26];
            visited = new boolean[N][M];
            // bfs 탐색을 진행할 Queue
            Queue<int[]> queue = new ArrayDeque<>();
            // 알파벳을 키로 하여 문들의 위치 정보를 갖는 Map
            Map<Character, List<int[]>> doorMap = new HashMap<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                doorMap.put(c, new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                String str = in.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = str.charAt(j);
                    if('A' <= board[i][j] && board[i][j] <= 'Z') {
                        doorMap.get(board[i][j]).add(new int[] {i, j});
                    }
                }
            }
            // 초기 열쇠 세팅
            for(char c : in.readLine().toCharArray()) {
                if(c == '0') break;
                keyArr[c - 'a'] = true;
            }

            // 진입 가능한 곳 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                        if(board[i][j] == '*') continue;
                        else if('A' <= board[i][j] && board[i][j] <= 'Z') {
                            if(keyArr[board[i][j] - 'A'])
                                queue.offer(new int[] {i, j});
                        }
                        else queue.offer(new int[] {i, j});
                    }
                }
            }

            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                if(visited[r][c]) continue;
                visited[r][c] = true;
                if(board[r][c] == '$') cnt++;
                else if('a' <= board[r][c] && board[r][c] <= 'z') {
                    keyArr[board[r][c] - 'a'] = true;
                    char door = Character.toUpperCase(board[r][c]);
                    for(int[] pos : doorMap.get(door)) {
                        if(isOpenableDoor(pos)) queue.offer(pos);
                    }
                }
                for (int d = 0; d < dr.length; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M
                            || visited[nr][nc] || board[nr][nc] == '*') continue;
                    if('A' <= board[nr][nc] && board[nr][nc] <= 'Z') {
                        if(keyArr[board[nr][nc] - 'A'])
                            queue.offer(new int[] {nr, nc});
                    }
                    else queue.offer(new int[] {nr, nc});
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    // 열쇠가 있더라도 주변 블록을 탐색했어야 문을 열 수 있음
    static boolean isOpenableDoor(int[] pos) {
        int r = pos[0];
        int c = pos[1];
        //가장자리에 있는 문이라면 열 수 있음
        if(r == 0 || r == N - 1 || c == 0 || c == M - 1) return true;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if(visited[nr][nc]) return true;
        }
        return false;
    }

}