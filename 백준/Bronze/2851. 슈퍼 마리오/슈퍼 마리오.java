import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] sum = new int[11];
        final int TARGET_NUM = 100;
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i <= 10; i++) {
            sum[i] = Integer.parseInt(in.readLine()) + sum[i - 1];
            int diff = Math.abs(TARGET_NUM - sum[i]);
            if(minDiff >= diff && sum[i] > res) {
                minDiff = diff;
                res = sum[i];
            }
        }
        System.out.println(res);
        in.close();
    }
}