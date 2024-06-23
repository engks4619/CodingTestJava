import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}