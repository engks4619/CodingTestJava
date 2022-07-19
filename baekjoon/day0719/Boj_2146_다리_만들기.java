package baekjoon.day0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2146_다리_만들기 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] board = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int num = 2;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 0 || visited[i][j]) continue;
                board[i][j] = num;
                visited[i][j] = true;
                queue.offer(new int[] {i, j});
                while(!queue.isEmpty()){
                    int[] pos = queue.poll();
                    int r = pos[0];
                    int c = pos[1];
                    for(int d = 0; d < 4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                        if(board[nr][nc] == 1){
                            board[nr][nc] = num;
                            visited[nr][nc] = true;
                            queue.offer(new int[] {nr, nc});
                        }
                    }
                }
                num++;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != 0){
                    int curr = board[i][j];
                    boolean[][] tmpVisited = new boolean[N][N];
                    Queue<int[]> tmpQueue = new ArrayDeque<>();
                    tmpVisited[i][j] = true;
                    tmpQueue.offer(new int[] {i, j, 0});
                    while (!tmpQueue.isEmpty()){
                        int[] pos = tmpQueue.poll();
                        int r = pos[0];
                        int c = pos[1];
                        int length = pos[2];
                        if(board[r][c] != 0 && board[r][c] != curr){
                            result = Math.min(result, length-1);
                            break;
                        }
                        for(int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if(nr < 0 || nr >= N || nc < 0 || nc >= N || tmpVisited[nr][nc] || board[nr][nc] == curr) continue;
                            tmpVisited[nr][nc] = true;
                            tmpQueue.offer(new int[] {nr, nc, length+1});
                        }
                    }
                }
            }
        }
        System.out.println(result);
        in.close();
    }


}
