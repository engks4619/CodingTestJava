import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int num : arr) {
            cnt += num / T;
            cnt += num % T != 0 ? 1 : 0;
        }
        System.out.println(cnt);
        System.out.println(N / P + " " + N % P);
        in.close();
    }
}