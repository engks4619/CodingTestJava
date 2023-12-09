import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] dp = new int[N][3];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < 3 ; i++) { // 첫번째 줄 값 초기화
			dp[0][i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N; i++) { // 두번째 줄 부터 이전 줄의 현재 열과 다른 값 중 최소값을 더해서 초기화
			st = new StringTokenizer(in.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		// 마지막 행의 값 중 최소 값이 전부 색칠하는 비용 중 최소
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
		in.close();
	}
}
