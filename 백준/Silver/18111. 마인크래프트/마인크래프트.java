import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, board[i][j]);
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }
        int minTime = Integer.MAX_VALUE;
        int height = 0;
        for (int h = minHeight; h <= maxHeight; h++) {
            int time = 0;
            int inventory = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = Math.abs(board[i][j] - h);
                    if(board[i][j] > h) {
                        time += 2 * diff;
                        inventory += diff;
                    } else {
                        time += diff;
                        inventory -= diff;
                    }
                }
            }
            if(inventory < 0) continue;
            if(minTime >= time) {
                if(minTime == time)
                    height = Math.max(height, h);
                else {
                    height = h;
                    minTime = time;
                }
            }
        }
        System.out.println(minTime + " " + height);
        in.close();
    }
}