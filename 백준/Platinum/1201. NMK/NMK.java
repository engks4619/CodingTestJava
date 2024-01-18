import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] arr;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];

        if(M * K < N || M + K > N + 1) answer.append("-1");
        else {
            initMaxNumArr();
            writeArr();
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void initMaxNumArr() {
        arr[1] = K;
        if(M - 1 <= 0) return;
        int cnt = (N - K) / (M - 1);
        int remain = (N - K) % (M - 1);
        for (int i = 2; i <= M; i++) {
            if(remain-- > 0) arr[i] = arr[i - 1] + cnt + 1;
            else arr[i] = arr[i - 1] + cnt;
        }
    }

    static void writeArr() {
        for (int i = 1; i <= M; i++) {
            for (int j = arr[i]; j > arr[i - 1]; j--) {
                answer.append(j).append(" ");
            }
        }
    }

}