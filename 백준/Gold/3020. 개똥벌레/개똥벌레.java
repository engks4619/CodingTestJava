import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[H + 1];
        int[] top = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(in.readLine());
            if(i % 2 == 0) bottom[height]++;
            else top[height]++;
        }
        for (int i = H - 1; i >= 1; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }
        int minCnt = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            int tmpCnt = bottom[i] + top[H - i + 1];
            if(minCnt > tmpCnt) {
                minCnt = tmpCnt;
                cnt = 1;
            }
            else if(minCnt == tmpCnt) {
                cnt++;
            }
        }
        System.out.println(minCnt + " " + cnt);
        in.close();
    }
}