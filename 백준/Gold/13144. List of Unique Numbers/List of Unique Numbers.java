import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[100001];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long cnt = 0;
        int l = 0;
        int r = 0;
        while(l < N) {
            while(r < N && !visited[arr[r]]) {
                visited[arr[r]] = true;
                r++;
            }
            cnt += r - l;
            visited[arr[l]] = false;
            l++;
        }
        System.out.println(cnt);
        in.close();
    }
}