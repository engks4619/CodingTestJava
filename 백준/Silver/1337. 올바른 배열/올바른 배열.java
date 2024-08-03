import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int SIZE = 5;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = 0;
        int minCnt = 4;
        while(l < N && r < N) {
            if(arr[r] - arr[l] < SIZE) {
                minCnt = Math.min(minCnt, SIZE - 1 - r + l);
                r++;
            }
            else l++;
        }
        System.out.println(minCnt);
        in.close();
    }
}