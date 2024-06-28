import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] lionArr = new int[K];
        int[] humanArr = new int[N - K];
        int lMax = 0;
        int lMin = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            lionArr[i] = Integer.parseInt(in.readLine());
            lMax = Math.max(lMax, lionArr[i]);
            lMin = Math.min(lMin, lionArr[i]);
        }
        for (int i = 0; i < N - K; i++) {
            humanArr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(humanArr);
        int hMin = humanArr[0];
        int hMax = humanArr[N - K - 1];
        int answer = 0;
        for (int i = 1; i < K; i++) {
            answer += Math.abs(lionArr[i] - lionArr[i - 1]);
        }
        if(hMin < lMin) {
            int diff = lMin - hMin;
            int minDiff = lionArr[0] == lMin || lionArr[K - 1] == lMin ? diff : 2 * diff;
            minDiff = Math.min(minDiff, lionArr[0] - hMin);
            minDiff = Math.min(minDiff, lionArr[K - 1] - hMin);
            answer += minDiff;
        }
        if(hMax > lMax) {
            int diff = hMax - lMax;
            int minDiff = lionArr[0] == lMax || lionArr[K - 1] == lMax ? diff : 2 * diff;
            minDiff = Math.min(minDiff, hMax - lionArr[0]);
            minDiff = Math.min(minDiff, hMax - lionArr[K - 1]);
            answer += minDiff;
        }
        System.out.println(answer);
        in.close();
    }

}