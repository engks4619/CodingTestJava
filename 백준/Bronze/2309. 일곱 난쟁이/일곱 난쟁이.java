import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N = 9;
    static int[] arr, selected;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[N];
        selected = new int[7];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        combination(0, 0, 0);

        Arrays.sort(selected);
        for (int height : selected) {
            System.out.println(height);
        }        
        in.close();
    }

    static boolean combination(int curr, int cnt, int sum){
        if(cnt == 7 && sum == 100) return true;
        if(cnt >= 7) return false;

        for (int i = curr; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[cnt] = arr[i];
            if(combination(i + 1,cnt + 1, sum + arr[i])) return true;
            visited[i] = false;
        }
        return false;
    }
}