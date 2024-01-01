import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, maxValue;
    static int[] arr, selected;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        maxValue = 0;
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0);
        bw.write(maxValue + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void permutation(int cnt){
        if(cnt == N){
            maxValue = Math.max(maxValue, sumLogic());
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            selected[cnt] = arr[i];
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

    static int sumLogic(){
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(selected[i] - selected[i + 1]);
        }
        return sum;
    }
}