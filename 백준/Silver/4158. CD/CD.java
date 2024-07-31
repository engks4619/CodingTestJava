import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            int[] arrA = new int[N];
            int[] arrB = new int[M];
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(in.readLine());
            }
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(in.readLine());
            }
            int cnt = 0;
            int i = 0;
            int j = 0;
            while (i < N && j < M) {
                if(arrA[i] == arrB[j]) {
                    cnt++;
                    i++;
                    j++;
                }
                else if(arrA[i] > arrB[j]) j++;
                else i++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}