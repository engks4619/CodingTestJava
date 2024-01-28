import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        bw.write(binarySearch(1, Integer.MAX_VALUE) + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static long binarySearch(long left, long right) {
        while(left <= right) {
            long mid = (left + right) / 2;
            if(isPossible(mid)) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    static boolean isPossible(long len) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += arr[i] / len;
        }
        return cnt >= N;
    }

}