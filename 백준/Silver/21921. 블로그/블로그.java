import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int l = 0;
        int r = X;
        for (int i = l; i < r; i++) {
            sum += arr[i];
        }
        int max = sum;
        int cnt = 1;
        while(l < r && r < N) {
            sum -= arr[l++];
            sum += arr[r++];
            if(sum > max) {
                max = sum;
                cnt = 1;
            }else if(sum == max)
                cnt++;
        }
        if(max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);
        in.close();
    }
}