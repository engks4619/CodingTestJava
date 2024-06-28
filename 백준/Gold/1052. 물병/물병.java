import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(getMinBuyCnt(N, K));
        in.close();
    }

    static int getMinBuyCnt(int N, int K) {
        int cnt = 0;
        while(Integer.bitCount(N++) > K) cnt++;
        return cnt;
    }

}