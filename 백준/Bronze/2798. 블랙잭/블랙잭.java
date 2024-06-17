import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max;
    static int[] arr;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        go(0, 0);
        System.out.println(max);
        in.close();
    }

    static void go(int cnt, int sum) {
        if(cnt == 3) {
            if(sum <= M) max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            go(cnt + 1, sum + arr[i]);
            selected[i] = false;
        }
    }
    
}