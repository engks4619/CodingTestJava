import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        int delCnt = 0;
        int maxLen = 0;
        while(r < N) {
            int num = arr[r];
            if(num % 2 == 0) {
                maxLen = Math.max(maxLen, r - l - delCnt + 1);
                r++;
                continue;
            }
            if(delCnt < K) {
                delCnt++;
                maxLen = Math.max(maxLen, r - l - delCnt + 1);
                r++;
            } else {
                while(true) {
                    if(arr[l++] % 2 != 0) {
                        delCnt--;
                        break;
                    }
                }
            }
        }
        System.out.println(maxLen);
        in.close();
    }
}