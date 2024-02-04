import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, cnt;
    static boolean[] isCheck = new boolean[10001];
    static int[] numArr = new int[] {1, 5, 10, 50};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        dfs(0, 0,0);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void dfs(int depth, int idx, int sum) {
        if(depth == N) {
            if(!isCheck[sum]) {
                isCheck[sum] = true;
                cnt++;
            }
            return;
        }
        for (int i = idx; i < numArr.length; i++) {
            dfs(depth + 1, i, sum + numArr[i]);
        }
    }

}