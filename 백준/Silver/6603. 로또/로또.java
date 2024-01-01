import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int LOTTO_SIZE = 6;
    static int[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            arr = new int[N];
            selected = new int[LOTTO_SIZE];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            go(0, 0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int idx, int cnt){
        if(cnt == LOTTO_SIZE){
            Arrays.stream(selected).forEach((num) -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[cnt] = arr[i];
            go(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}