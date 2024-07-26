import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(isGood(i)) cnt++;
        }
        System.out.println(cnt);
        in.close();
    }

    static boolean isGood(int targetIdx) {
        int target = arr[targetIdx];
        int l = 0;
        int r = N - 1;
        while(l < r) {
            if(l == targetIdx) {
                l++;
                continue;
            }
            if(r == targetIdx) {
                r--;
                continue;
            }
            int sum = arr[l] + arr[r];
            if(sum == target) return true;
            else if(sum < target) l++;
            else r--;
        }
        return false;
    }

}