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
        int[] arr = new int[N * 2];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            arr[i + N] = arr[i];
        }
        int[] cntArr = new int[d + 1];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            cntArr[arr[i]]++;
        }
        cntArr[c]++;
        for (int i = 1; i <= d; i++) {
            if(cntArr[i] >= 1) cnt++;
        }
        int maxCnt = cnt;
        int l = 0;
        int r = k - 1;
        while(r < 2 * N - 1 && maxCnt != d) {
            int leftNum = arr[l++];
            int rightNum = arr[++r];
            if(--cntArr[leftNum] == 0) cnt--;
            if(++cntArr[rightNum] == 1) cnt++;
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
        in.close();
    }

}