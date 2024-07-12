import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(getMinDistance(N, K, arr));
        in.close();
    }

    static int getMinDistance(int N, int K, int[] arr) {
        if(K >= N) return 0;

        Arrays.sort(arr);
        int[] diffArr = new int[N - 1];
        for (int i = 1; i < N; i++) {
            diffArr[i - 1] = arr[i] - arr[i - 1];
        }
        Arrays.sort(diffArr);
        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += diffArr[i];
        }
        return answer;
    }

}