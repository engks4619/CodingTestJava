import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
			}
		}
		System.out.println(dp[N]);
		in.close();
	}
	
}
