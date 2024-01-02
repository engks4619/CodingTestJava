import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        int maxSum = 0;
        Queue<boolean[][]> queue = getDividedBoardQueue();
        while(!queue.isEmpty()){
            maxSum = Math.max(maxSum, getSum(queue.poll()));
        }
        bw.write(maxSum + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static Queue<boolean[][]> getDividedBoardQueue(){
        Queue<boolean[][]> queue = new ArrayDeque<>();
        for (int s = 0; s < (1 << N * M); s++) {
            boolean[][] board = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int k = i * M + j;
                    if((s & (1 << k)) != 0) board[i][j] = true;
                }
            }
            queue.offer(board);
        }

        return queue;
    }

    static int getSum(boolean[][] selected){
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = M - 1; j >= 0; j--) {
                if(selected[i][j]) sum += board[i][j] * Math.pow(10, cnt++);
                else cnt = 0;
            }
        }
        for (int j = 0; j < M; j++) {
            int cnt = 0;
            for (int i = N - 1; i >= 0; i--) {
                if(!selected[i][j]) sum += board[i][j] * Math.pow(10, cnt++);
                else cnt = 0;
            }
        }
        return sum;
    }
}