import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static boolean[] checkNum = new boolean[100000 * 20 + 1];
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        go(0, 0);
        for (int i = 1; i <= checkNum.length; i++) {
            if(!checkNum[i]) {
                answer = i;
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int cnt, int sum) {
        if(cnt == N) {
            checkNum[sum] = true;
            return;
        }
        go(cnt + 1, sum);
        go(cnt + 1, sum + arr[cnt]);
    }

}