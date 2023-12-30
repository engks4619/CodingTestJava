import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String N;
	static int result;
	static boolean[] isBroken = new boolean[11];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = in.readLine();
		result = Integer.MAX_VALUE;
		int M = Integer.parseInt(in.readLine());
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}			
		}
		go("", 0, 0);
		result = Math.min(result, Math.abs(Integer.parseInt(N) - 100));
		System.out.println(result);
		in.close();
	}

	static void go(String curr, int n, int count) {
		if(!curr.equals("")) {
			int currVal = Integer.parseInt(curr);			
			if (currVal == Integer.parseInt(N)) {
				result = Math.min(result, count);
			}else {
				int diff = Math.abs(currVal - Integer.parseInt(N));
				result = Math.min(result, count + diff);
			}			
		}
		
		if (n == 6) {	
			return;
		}
		for(int i = 0; i <= 9; i++) {
			if(isBroken[i]) continue;
			char c = Character.forDigit(i, 10);
			go(curr + c, n + 1, count + 1);
		}
		
	}
}
