import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = in.readLine();
        int[][] cntArr = new int[26][S.length()];
        int q = Integer.parseInt(in.readLine());
        for (int i = 0; i < 26; i++) {
            int cnt = 0;
            for (int j = 0; j < S.length(); j++) {
                if(S.charAt(j) - 'a' == i) cnt++;
                cntArr[i][j] = cnt;
            }
        }
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(getCnt(a, l, r, cntArr)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static int getCnt(char a, int l, int r, int[][] cntArr) {
        int idx = a - 'a';
        if(l == 0) return cntArr[idx][r];
        return cntArr[idx][r] - cntArr[idx][l - 1];
    }

}