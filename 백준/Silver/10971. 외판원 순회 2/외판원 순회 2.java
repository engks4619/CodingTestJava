import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, minDistance;
    static boolean[] visited;
    static int[] selected;
    static int[][] costBoard;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        minDistance = Integer.MAX_VALUE;
        costBoard = new int[N][N];
        visited = new boolean[N];
        selected = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                costBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0);
        bw.write(minDistance + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int cnt){
        if(cnt == N){
            minDistance = Math.min(minDistance, getDistance());
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[cnt] = i;
            go(cnt + 1);
            visited[i] = false;
        }
    }

    static int getDistance(){
        int distance = 0;
        for (int i = 0; i < N - 1; i++) {
            int prev = selected[i];
            int next = selected[i + 1];
            int tmpDist = costBoard[prev][next];
            if(tmpDist == 0) return Integer.MAX_VALUE;
            distance += tmpDist;
        }
        int backDist = costBoard[selected[N - 1]][selected[0]];
        if(backDist == 0) return Integer.MAX_VALUE;
        return distance + backDist;
    }
}