import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }
        int l = 0;
        int r = Math.min(2 * K, arr.length - 1);
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            cnt += arr[i];
        }
        int maxCnt = cnt;
        while(r < arr.length - 1) {
            cnt += arr[++r];
            cnt -= arr[l++];
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
        in.close();
    }
}