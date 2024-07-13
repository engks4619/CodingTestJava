import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String str = in.readLine();
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'S') {
                cnt++;
                continue;
            }
            i++;
            cnt++;
        }
        System.out.println(Math.min(cnt, N));
        in.close();
    }
}