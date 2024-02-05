import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == '*') queue.offer(new int[] {i, j});
            }
        }

        Queue<String> logQueue = new ArrayDeque<>();
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int size = 0;
            int k = 1;
            while (r - k >= 0 && r + k < N && c - k >= 0 && c + k < M) {
                if (board[r - k][c] == '*' && board[r + k][c] == '*' && board[r][c - k] == '*' && board[r][c + k] == '*') {
                    visited[r - k][c] = true;
                    visited[r + k][c] = true;
                    visited[r][c - k] = true;
                    visited[r][c + k] = true;
                    size = k;
                    k++;
                }else break;

            }
            if(size > 0) {
                visited[r][c] = true;
                logQueue.offer((r + 1) + " " + (c + 1) + " " + size);
            }
        }

        boolean isPossible = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == '*' && !visited[i][j]) {
                    isPossible = false;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(logQueue.size()).append("\n");
        while(!logQueue.isEmpty()) sb.append(logQueue.poll()).append("\n");
        bw.write(isPossible ? sb.toString(): "-1");
        bw.flush();
        bw.close();
        in.close();
    }
    
}