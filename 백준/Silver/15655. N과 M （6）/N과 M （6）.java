import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, selected;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(0, 0);
        System.out.print(sb);
        in.close();
    }

    static boolean permutation(int idx, int cnt){
        if(cnt == M){
            for(int num : selected){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return true;
        }
        for (int i = idx; i < N; i++) {
            selected[cnt] = arr[i];
            permutation(i + 1, cnt + 1);
        }
        return false;
    }
}