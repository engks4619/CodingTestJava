import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, maxEnergy;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        go(0, 0);
        bw.write(maxEnergy + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int cnt, int sum){
        if(cnt == N - 2){
            maxEnergy = Math.max(maxEnergy, sum);
            return;
        }
        for (int i = 1; i < N - 1; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            int left = getIdx('L', i - 1);
            int right = getIdx('R', i + 1);
            go(cnt + 1, sum + arr[left] * arr[right]);
            visited[i] = false;
        }
    }

    static int getIdx(char direction, int currIdx) {
        int idx = currIdx;
        switch (direction){
            case 'L':
                while(visited[idx]) idx--;
                break;
            case 'R':
                while(visited[idx]) idx++;
                break;
        }
        return idx;
    }

}