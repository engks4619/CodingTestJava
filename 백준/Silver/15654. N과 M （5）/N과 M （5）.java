import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(0);
        System.out.print(sb);
        in.close();
    }

    static boolean permutation(int cnt){
        if(cnt == M){
            for(int num : selected){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return true;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            selected[cnt] = arr[i];
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
        return false;
    }
}