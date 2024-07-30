import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[2 * N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            arr[i + N] = arr[i];
        }
        int[] cntArr = new int[d + 1];
        cntArr[c]++;
        for (int i = 0; i < k; i++) {
            cntArr[arr[i]]++;
        }
        int cnt = 0;
        for (int i = 1; i <= d; i++) {
            if(cntArr[i] >= 1) cnt++;
        }
        int maxCnt = cnt;
        int l = 0;
        int r = k - 1;
        while(r < 2 * N - 1 && maxCnt != d) {
            int lNum = arr[l++];
            int rNum = arr[++r];
            if(--cntArr[lNum] == 0) cnt--;
            if(++cntArr[rNum] == 1) cnt++;
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
        in.close();
    }
}