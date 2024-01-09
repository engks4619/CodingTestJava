import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.function.BiFunction;

public class Main {

    static int N, minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;
    static int[] arr;
    static int[] opCntArr = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 4; i++) {
            opCntArr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, arr[0]);
        bw.write(maxSum + "\n" + minSum + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void dfs(int cnt, int sum){
        if(cnt == N){
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(opCntArr[i] <= 0) continue;
            opCntArr[i]--;
            dfs(cnt + 1, calculateMap.get(i).apply(sum, arr[cnt]));
            opCntArr[i]++;
        }
    }

    static Map<Integer, BiFunction<Integer, Integer, Integer>> calculateMap = new HashMap<>();
    static {
        calculateMap.put(0, (a, b) -> a + b);
        calculateMap.put(1, (a, b) -> a - b);
        calculateMap.put(2, (a, b) -> a * b);
        calculateMap.put(3, (a, b) -> a / b);
    }
}