import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cntArr = new int[10];
        int l = 0, r = 0;
        int maxCnt = 0;
        int typeCnt = 0;
        while(r < N) {
            if(cntArr[arr[r]]++ == 0) typeCnt++;
            if(typeCnt <= 2) maxCnt = Math.max(maxCnt, r - l + 1);
            else {
                if(--cntArr[arr[l]] == 0) typeCnt--;
                l++;
            }
            r++;
        }
        System.out.println(maxCnt);
        in.close();
    }
}