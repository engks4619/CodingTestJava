import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 29;
    static int K;
    static boolean[][] visited = new boolean[N][N];
    static double[] percentArr = new double[4];
    static int[] dr = {0, 0, 1, -1}; // 동 서 남 북
    static int[] dc = {1, -1, 0, 0};

    static double answer;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percentArr[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }
        visited[14][14] = true;
        go(14, 14, 0, 1);
        System.out.println(answer);
        in.close();
    }

    static void go(int r, int c, int cnt, double percent) {
        if(cnt == K) {
            answer += percent;
            return;
        }
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
                continue;
            visited[nr][nc] = true;
            go(nr, nc, cnt + 1, percent * percentArr[d]);
            visited[nr][nc] = false;
        }

    }

}