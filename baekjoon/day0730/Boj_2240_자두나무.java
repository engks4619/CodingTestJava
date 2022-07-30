package baekjoon.day0730;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2240_자두나무 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] dp = new int[T + 1][W + 1];
        for (int t = 1; t <= T; t++) {
            int tree = Integer.parseInt(in.readLine());
            if (t == 1) {
                if (tree == 1) {
                    dp[1][0] = 1;
                    dp[1][1] = 0;
                } else {
                    dp[1][0] = 0;
                    dp[1][1] = 1;
                }
                continue;
            }
            for (int w = 0; w <= W; w++) {
                if (w == 0) { // 안 움직이는경우 => 위치 1
                    if (tree == 1) {
                        dp[t][w] = dp[t - 1][w] + 1;
                    } else {
                        dp[t][w] = dp[t - 1][w];
                    }
                    continue;
                }
                if (w % 2 == 0) { // 움직인 횟수 짝수 => 위치 1
                    if (tree == 1) {
                        dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]) + 1;
                    } else {
                        dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]);
                    }
                } else { // 움직인 횟수 홀수 => 위치 2
                    if (tree == 1) {
                        dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]);
                    } else {
                        dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]) + 1;
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int w = 0; w <= W; w++) {
            result = Math.max(result, dp[T][w]);
        }
        System.out.println(result);
        in.close();
    }

}
