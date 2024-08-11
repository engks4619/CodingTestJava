import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
        M = Integer.parseInt(in.readLine());
        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = getSum(mid);
            if(sum <= M) {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        System.out.println(right);
        in.close();
    }

    static long getSum(int val) {
        long sum = 0;
        for (int num : arr) {
            sum += Math.min(num, val);
        }
        return sum;
    }
}