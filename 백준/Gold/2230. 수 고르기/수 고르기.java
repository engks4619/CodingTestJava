import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = 0;
        int minDiff = Integer.MAX_VALUE;
        while(r < N) {
            int diff = arr[r] - arr[l];
            if(diff < M) {
                r++;
                continue;
            }
            l++;
            minDiff = Math.min(minDiff, diff);
            if(minDiff == M) break;
        }
        System.out.println(minDiff);
        in.close();
    }
}