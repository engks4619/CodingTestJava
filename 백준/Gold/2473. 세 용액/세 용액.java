import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long minDiff = Long.MAX_VALUE, arr[], answer[] = new long[3];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N - 2; i++) {
            go(i);
        }

        for(long num : answer) {
            System.out.print(num + " ");
        }
        in.close();
    }

    static void go(int idx) {
        int left = idx + 1;
        int right = N - 1;
        while(left < right) {
            long sum = arr[left] + arr[right] + arr[idx];
            long diff = Math.abs(sum);
            if(minDiff > diff) {
                answer[0] = arr[idx];
                answer[1] = arr[left];
                answer[2] = arr[right];
                minDiff = diff;
            }
            if(sum < 0) left++;
            else right--;
        }
    }

}