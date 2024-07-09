import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new LinkedList<>();
        for (int i = N; i >= 1; i--) {
            int idx = arr[i];
            list.add(idx, i);
        }
        StringBuilder sb = new StringBuilder();
        for(int height : list) {
            sb.append(height).append(" ");
        }
        System.out.println(sb);
        in.close();
    }

}