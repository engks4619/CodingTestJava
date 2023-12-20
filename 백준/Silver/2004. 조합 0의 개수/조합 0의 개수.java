import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // nCm 조합의 수 N!/(N-M)!M!  10은 2*5이므로 2의 갯수 5의
        int twoCnt = getTwoCnt(N) - getTwoCnt(N - M) - getTwoCnt(M);
        int fiveCnt = getFiveCnt(N) - getFiveCnt(N - M) - getFiveCnt(M);
        int result = Math.min(twoCnt, fiveCnt);
        System.out.println(result);
        in.close();
    }

    static int getTwoCnt(int num){
        int cnt = 0;
        while(num > 0){
            cnt += num / 2;
            num /= 2;
        }
        return cnt;
    }

    static int getFiveCnt(int num){
        int cnt = 0;
        while(num > 0){
            cnt += num / 5;
            num /= 5;
        }
        return cnt;
    }

}