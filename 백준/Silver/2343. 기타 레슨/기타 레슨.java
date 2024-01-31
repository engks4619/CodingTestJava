import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(in.readLine());
        int left = 1;
        int right = (int) 1e9;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) right = mid - 1;
            else left = mid + 1;
        }
        bw.write(left + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean isPossible(int val) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > val) {
                sum = arr[i];
                cnt++;
            }
        }
        return cnt <= M;
    }
}