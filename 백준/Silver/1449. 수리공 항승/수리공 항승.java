import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] holeArr = new int[N];
        boolean[] isLeaked = new boolean[1001];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            holeArr[i] = Integer.parseInt(st.nextToken());
            isLeaked[holeArr[i]] = true;
        }
        Arrays.sort(holeArr);
        int cnt = 0;
        for(int idx : holeArr) {
            if(!isLeaked[idx]) continue;
            for (int i = 0; i < L; i++) {
                if(idx + i > 1000) continue;
                isLeaked[idx + i] = false;
            }
            cnt++;
        }
        System.out.println(cnt);
        in.close();
    }

}