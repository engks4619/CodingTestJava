import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(in.readLine());
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if((X & 1 << i) != 0) cnt++;
        }
        System.out.println(cnt);
        in.close();
    }
}