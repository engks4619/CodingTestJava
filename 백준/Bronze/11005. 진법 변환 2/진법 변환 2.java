import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[36];
        for (int i = 0; i < 36; i++) {
            arr[i] = i < 10 ? (char)('0' + i) : (char) ('A' + i - 10);
        }
        while(N != 0){
            int r = N % B;
            N /= B;
            sb.append(arr[r]);
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == 0){
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
        in.close();
    }
}