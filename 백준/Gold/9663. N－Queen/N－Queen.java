import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, result;
    static boolean[] visitedCol;
    static boolean[] visitedDiagA;
    static boolean[] visitedDiagB;

    static int[] dr = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dc = {0, 0, -1, 1, 1, -1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        visitedCol = new boolean[N];
        visitedDiagA = new boolean[2 * N - 1];
        visitedDiagB = new boolean[2 * N - 1];
        go(0);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int r){
        if(r == N){
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(checkVisited(r, i)) continue;
            updateVisited(r, i, true);
            go(r + 1);
            updateVisited(r, i, false);
        }
    }

    static boolean checkVisited(int r, int c) {
        return (visitedCol[c] || visitedDiagA[r + c] || visitedDiagB[r - c + N - 1]);
    }

    static void updateVisited(int r, int c, boolean flag) {
        visitedCol[c] = flag;
        visitedDiagA[r + c] = flag;
        visitedDiagB[r - c + N - 1] = flag;
    }

}