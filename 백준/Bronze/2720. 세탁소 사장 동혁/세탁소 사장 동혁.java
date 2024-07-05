import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[] {25, 10, 5, 1};
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int C = Integer.parseInt(in.readLine());
            for (int i = 0; i < arr.length; i++) {
                sb.append(C / arr[i]).append(" ");
                C %= arr[i];
            }
            sb.append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}