import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static int M, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        if(N <= M) answer = (int) N;
        else {
            long result = binarySearch(0, N * 30);
            long cnt = getCnt(result - 1);
            for (int i = 0; i < M; i++) {
                if(result % arr[i] == 0) cnt++;
                if(cnt == N) {
                    answer = i + 1;
                    break;
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static long binarySearch(long left, long right) {
        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = getCnt(mid);
            if(cnt < N) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    static long getCnt(long val) {
        long cnt = M;
        for (int i = 0; i < M; i++) {
            cnt += val / arr[i];
        }
        return cnt;
    }

}