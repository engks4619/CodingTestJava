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
        int left = 0;
        int right = N - 1;
        int l = 0;
        int r = N - 1;
        long minDiff = Long.MAX_VALUE;
        while(left < right) {
            long sum = arr[left] + arr[right];
            long diff = Math.abs(sum);
            if(minDiff > diff) {
                minDiff = diff;
                l = left;
                r = right;
            }
            if(sum == 0) break;
            else if(sum < 0) left++;
            else right--;
        }
        System.out.println(arr[l] + " " + arr[r]);
        in.close();
    }

}