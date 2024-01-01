import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] scoreBoard;
    static int minScoreDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        scoreBoard = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                scoreBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, 0, new boolean[N]);
        bw.write(minScoreDiff + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void combination(int idx, int cnt, boolean[] selected){
        if(cnt >= N) return;
        if(cnt > 0){
            List<Integer> teamStart = new ArrayList<>(N / 2);
            List<Integer> teamLink = new ArrayList<>(N / 2);
            for (int i = 0; i < N; i++) {
                if(selected[i]) teamStart.add(i);
                else teamLink.add(i);
            }
            minScoreDiff = Math.min(minScoreDiff, Math.abs(getScore(teamStart) - getScore(teamLink)));
        }
        for (int i = idx; i < N; i++) {
            selected[i] = true;
            combination(i + 1,cnt + 1, selected);
            selected[i] = false;
        }
    }

    static int getScore(List<Integer> team){
        int score = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                score += scoreBoard[team.get(i)][team.get(j)];
            }
        }
        return score;
    }
}