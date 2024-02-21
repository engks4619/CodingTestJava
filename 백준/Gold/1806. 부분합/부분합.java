import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int minLength = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(l <= r && r <= N) {
            if(sum >= S) {
                minLength = Math.min(minLength, r - l);
                sum -= arr[l++];
            }
            else sum += arr[r++];
        }
        String answer = minLength == Integer.MAX_VALUE ? "0" : minLength + "";
        bw.write(answer);
        bw.flush();
        bw.close();
        in.close();
    }

}