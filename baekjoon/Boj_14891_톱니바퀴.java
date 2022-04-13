package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14891_톱니바퀴 {

	static Tobni[] tobnis;
	static int[] directions;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		tobnis = new Tobni[5];

		for (int i = 1; i <= 4; i++) {
			String s = in.readLine();
			tobnis[i] = new Tobni();
			tobnis[i].u = s.charAt(0)-'0';
			tobnis[i].ru = s.charAt(1)-'0';
			tobnis[i].r = s.charAt(2)-'0';
			tobnis[i].rd = s.charAt(3)-'0';
			tobnis[i].d = s.charAt(4)-'0';
			tobnis[i].ld = s.charAt(5)-'0';
			tobnis[i].l = s.charAt(6)-'0';
			tobnis[i].lu = s.charAt(7)-'0';
		}

		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			directions = new int[5];
			checkDirection(num, dir);
			rotate();
		}

		int result = 0;
		for (int i = 1; i <= 4; i++) {
			if (tobnis[i].u == 1) {
				result += 1 << (i - 1);
			}
		}
		System.out.println(result);
		in.close();
	}

	static void checkDirection(int num, int dir) {
		if (directions[num] != 0)
			return; // 이미 톱니바퀴가 돌아갔다면 넘기기
		directions[num] = dir;
		int left = num - 1;
		if (left >= 1) {
			if (tobnis[left].r != tobnis[num].l) {
				checkDirection(left, dir * -1);
			}
		}
		int right = num + 1;
		if (right <= 4) {
			if (tobnis[right].l != tobnis[num].r) {
				checkDirection(right, dir * -1);
			}
		}

	}

	static void rotate() {
		for (int i = 1; i <= 4; i++) {
			int dir = directions[i];
			int temp = tobnis[i].u;
			switch (dir) {
			case 1: // 시계방향
				tobnis[i].u = tobnis[i].lu;
				tobnis[i].lu = tobnis[i].l;
				tobnis[i].l = tobnis[i].ld;
				tobnis[i].ld = tobnis[i].d;
				tobnis[i].d = tobnis[i].rd;
				tobnis[i].rd = tobnis[i].r;
				tobnis[i].r = tobnis[i].ru;
				tobnis[i].ru = temp;
				break;
			case -1: // 반시계방향
				tobnis[i].u = tobnis[i].ru;
				tobnis[i].ru = tobnis[i].r;
				tobnis[i].r = tobnis[i].rd;
				tobnis[i].rd = tobnis[i].d;
				tobnis[i].d = tobnis[i].ld;
				tobnis[i].ld = tobnis[i].l;
				tobnis[i].l = tobnis[i].lu;
				tobnis[i].lu = temp;
				break;
			}
		}
	}

	static class Tobni {
		int u, ru, r, rd, d, ld, l, lu;

		public Tobni() {}
		
		public Tobni(int u, int ru, int r, int rd, int d, int ld, int l, int lu) {
			this.u = u;
			this.ru = ru;
			this.r = r;
			this.rd = rd;
			this.d = d;
			this.ld = ld;
			this.l = l;
			this.lu = lu;
		}

	}
}
