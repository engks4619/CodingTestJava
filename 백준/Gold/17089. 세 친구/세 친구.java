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
        boolean[][] friendArr = new boolean[N + 1][N + 1];
        int[] friendCntArr = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendArr[a][b] = true;
            friendArr[b][a] = true;
            friendCntArr[a]++;
            friendCntArr[b]++;
        }
        int minCnt = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if(i == j || !friendArr[i][j]) continue;
                for (int k = 0; k <= N; k++) {
                    if(k == i || k == j || !friendArr[i][k] || ! friendArr[j][k]) continue;
                    int cnt = friendCntArr[i] + friendCntArr[j] + friendCntArr[k] - 6;
                    minCnt = Math.min(minCnt, cnt);
                }
            }
        }
        bw.write(minCnt == Integer.MAX_VALUE ? "-1\n" : minCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }
    
}