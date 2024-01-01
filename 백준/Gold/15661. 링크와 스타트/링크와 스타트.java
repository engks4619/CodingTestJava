import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int minScoreDiff = Integer.MAX_VALUE;
    static int[] teamA, teamB;
    static int[][] scoreBoard;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        scoreBoard = new int[N][N];
        teamA = new int[N];
        teamB = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                scoreBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, 0, 0, 0);
        bw.write(minScoreDiff + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int cnt, int aCnt, int bCnt, int aScore, int bScore){
        if(cnt == N){
            if(aCnt == 0 || bCnt == 0) return;
            minScoreDiff = Math.min(minScoreDiff, Math.abs(aScore - bScore));
            return;
        }

        int score = 0;
        for (int i = 0; i < aCnt; i++) {
            score += scoreBoard[teamA[i]][cnt] + scoreBoard[cnt][teamA[i]];
        }
        teamA[aCnt] = cnt;
        go(cnt + 1, aCnt + 1, bCnt, aScore + score, bScore);

        score = 0;
        for (int i = 0; i < bCnt; i++) {
            score += scoreBoard[teamB[i]][cnt] + scoreBoard[cnt][teamB[i]];
        }
        teamB[bCnt] = cnt;
        go(cnt + 1, aCnt, bCnt + 1, aScore, bScore + score);
    }
}