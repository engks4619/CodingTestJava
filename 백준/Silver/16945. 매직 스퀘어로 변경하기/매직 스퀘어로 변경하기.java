import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N = 3, minCost = Integer.MAX_VALUE;
    static int[][] board = new int[N][N];
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,  0);
        bw.write(minCost + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int cnt, int cost) {
        if(cost >= minCost) return;
        if(cnt == N * N) {
            if(isMagicSquare()) minCost = Math.min(minCost, cost);
            return;
        }
        int r = cnt / N;
        int c = cnt % N;
        for (int k = 1; k <= 9; k++) {
            if(visited[k]) continue;
            int num = board[r][c];
            board[r][c] = k;
            visited[k] = true;
            go(cnt + 1, cost + Math.abs(num - k));
            visited[k] = false;
            board[r][c] = num;
        }
    }

    static boolean isMagicSquare() {
        int sum = 45 / N;
        int rcSum1 = 0;
        int rcSum2 = 0;
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += board[i][j];
                colSum += board[j][i];
            }
            if(rowSum != sum || colSum != sum) return false;
            rcSum1 += board[i][i];
            rcSum2 += board[N - i - 1][i];
        }
        return rcSum1 == sum && rcSum2 == sum;
    }

}