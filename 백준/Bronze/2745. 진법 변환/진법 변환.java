import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int num = 0;
        for (int i = 0; i < N.length(); i++) {
            int tmp = N.charAt(i) <= '9' ? N.charAt(i) - '0' : N.charAt(i) - 'A' + 10;
            num += tmp * Math.pow(B, N.length() - i - 1);
        }
        System.out.println(num);
        in.close();
    }
}