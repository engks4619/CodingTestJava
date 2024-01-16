import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int teamCnt = M;
        int remain = N + M - (teamCnt * 3);
        while(teamCnt > 0) {
            if(N / teamCnt >= 2 && remain >= K) break;
            teamCnt--;
            remain = N + M - (teamCnt * 3);
        }
        bw.write(teamCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }
    
}