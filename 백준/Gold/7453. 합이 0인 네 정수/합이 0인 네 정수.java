import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static long[] sumArrA, sumArrB;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][4];
        for (int i = 0; i < N; i++) {
           StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sumArrA = new long[N * N];
        sumArrB = new long[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumArrA[i * N + j] = arr[i][0] + arr[j][1];
                sumArrB[i * N + j] = arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(sumArrA);
        Arrays.sort(sumArrB);

        bw.write(getCnt() + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static long getCnt() {
        long cnt = 0;
        int l = 0;
        int r = N * N - 1;
        while(l < N * N && r >= 0) {
            long a = sumArrA[l];
            long b = sumArrB[r];
            long sum = a + b;
            if(sum == 0) {
                long aCnt = 0;
                long bCnt = 0;
                while(l < N * N && sumArrA[l] == a) {
                    l++;
                    aCnt++;
                }
                while(r >= 0 && sumArrB[r] == b) {
                    r--;
                    bCnt++;
                }
                cnt += aCnt * bCnt;
            }else if(sum < 0) l++;
            else r--;
        }
        return cnt;
    }

}