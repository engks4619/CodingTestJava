import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int start = 0; start < 3; start++) {
            answer = Math.min(answer, getMinValue(start));
        }
        System.out.println(answer);
        in.close();
    }

    static int getMinValue(int start){
        //시작하는 곳을 제외한 나머지는 시작못하게 최대값으로 초기화
        Arrays.fill(dp[0], (int) 1e9);
        dp[0][start] = arr[0][start];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
        }
        //마지막과 첫번째가 같으면 안되므로 선택 안되게 최대값으로 만들기
        dp[N - 1][start] = (int) 1e9;
        return Arrays.stream(dp[N - 1]).min().getAsInt();
    }
}