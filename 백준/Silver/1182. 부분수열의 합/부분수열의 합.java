import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int totalCount = 0;
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < (1<<N); i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}
			if(sum == S) totalCount++;
		}
		System.out.println(totalCount);
		in.close();
	}
}
