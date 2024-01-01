import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L,C;
	static char[] data;
	static char[] selected;
	static char[] moum = {'a','e','i','o','u'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[C];
		selected = new char[L];
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < C; i++) {
			data[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(data);
		combination(0, 0);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == L) {
			int mCount = 0; // 모음 갯수
			int jCount = 0; // 자음 갯수
			for(int i = 0; i < L; i++) {
				//모음이면 모음갯수, 자음이면 자음갯수 증가
				boolean moumFlag = false;
				for(char m : moum) {
					if(m == selected[i]) {
						moumFlag = true;
						mCount++;
						break;
					}
				}
				if(!moumFlag) {
					jCount++;
				}
			}
			//모음이 한개 이상 자음이 2개이상이면 출력
			if(mCount >= 1 && jCount >= 2) {
				for(char c : selected)
					System.out.print(c);
				System.out.println();
			}
			return;
		}
		for (int i = start; i < data.length; i++) {
			selected[cnt] = data[i];
			combination(cnt+1, i+1);
		}
	}
}
