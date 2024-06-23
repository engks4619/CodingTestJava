import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N, K;
    static int[] arr;
    static boolean[] selected;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        K = Integer.parseInt(in.readLine());
        arr = new int[N];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        go(0, "");
        System.out.println(set.size());
        in.close();
    }

    static void go(int cnt, String num) {
        if(cnt == K) {
            set.add(Integer.parseInt(num));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            go(cnt + 1, num + arr[i]);
            selected[i] = false;
        }
    }

}