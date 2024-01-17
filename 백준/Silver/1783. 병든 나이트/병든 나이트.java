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
        int maxCnt;
        if(N == 1) maxCnt = 1;
        else if(N == 2) maxCnt = Math.min((M + 1) / 2, 4);
        else if(M < 7) maxCnt = Math.min(M, 4);
        else maxCnt = M - 2;
        bw.write(maxCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }
}