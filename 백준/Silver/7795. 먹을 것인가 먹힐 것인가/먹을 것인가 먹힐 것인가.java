import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(TC-- > 0) {
            st = new StringTokenizer(in.readLine());
            int[] arrA = new int[Integer.parseInt(st.nextToken())];
            int[] arrB = new int[Integer.parseInt(st.nextToken())];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < arrA.length; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < arrB.length; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            int curA = 0;
            int curB = 0;
            int cnt = 0;
            while(curA != arrA.length && curB != arrB.length) {
                if(arrA[curA] > arrB[curB]) {
                    cnt += arrA.length - curA;
                    curB++;
                }
                else curA++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}