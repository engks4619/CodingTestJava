import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int min;
	static int[][] synergy;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		min = Integer.MAX_VALUE;
		N = Integer.parseInt(in.readLine());
		synergy = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] p = new int[N];
		int cnt = 0;
		while (++cnt <= N / 2)
			p[N - cnt] = 1;

		do {
			List<Integer> materialA = new ArrayList<Integer>(N / 2);
			List<Integer> materialB = new ArrayList<Integer>(N / 2);
			for (int i = 0; i < N; i++) {
				if (p[i] == 1)
					materialA.add(i);
				else
					materialB.add(i);
			}
			int tasteA = getTasteScore(materialA);
			int tasteB = getTasteScore(materialB);
			min = Math.min(min, Math.abs(tasteA - tasteB));
		} while (np(p));
		System.out.println(min);
		in.close();
	}

	private static boolean np(int[] p) {
		int N = p.length;
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;
		swap(p, i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap(p, i++, k--);
		}
		return true;
	}

	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

	static int getTasteScore(List<Integer> material) {
		int tasteScore = 0;
		for (int i = 0; i < material.size() - 1; i++) {
			for (int j = i + 1; j < material.size(); j++) {
				int I = material.get(i);
				int J = material.get(j);
				tasteScore += synergy[I][J] + synergy[J][I];
			}
		}
		return tasteScore;
	}
}
