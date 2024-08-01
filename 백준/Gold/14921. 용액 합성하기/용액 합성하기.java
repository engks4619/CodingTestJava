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
        int minDiff = Integer.MAX_VALUE;
        int l = 0;
        int r = N - 1;
        int answer = Integer.MAX_VALUE;
        while(l < r) {
            int sum = arr[l] + arr[r];
            if(minDiff > Math.abs(sum)) {
                minDiff = Math.abs(sum);
                answer = sum;
            }
            if(sum > 0) r--;
            else l++;
        }
        System.out.println(answer);
        in.close();
    }
}