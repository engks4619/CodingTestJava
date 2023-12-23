import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(in.readLine());
            cnt = 0;
            getCnt(N, 0);
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void getCnt(int N, int sum){
        if(sum > N) return;
        if(sum == N){
            cnt++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            getCnt(N, sum + i);
        }
        return;
    }
}