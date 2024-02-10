import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int cnt;
    static int[] selected = new int[3];
    static boolean[][] isBadCombination;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isBadCombination = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isBadCombination[a][b] = isBadCombination[b][a] = true;
        }
        go(0, 1);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int depth, int curr) {
        if (depth == 3) {
            int a = selected[0];
            int b = selected[1];
            int c = selected[2];
            if (!isBadCombination[a][b] && !isBadCombination[b][a]
                    && !isBadCombination[a][c] && !isBadCombination[c][a]
                    && !isBadCombination[b][c] && !isBadCombination[c][b])
                cnt++;
            return;
        }
        for (int i = curr; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[depth] = i;
            go(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}