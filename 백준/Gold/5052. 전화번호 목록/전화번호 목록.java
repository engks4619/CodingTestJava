import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());
        while(TC-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = in.readLine();
            }
            Arrays.sort(arr);
            boolean flag = true;
            for (int i = 0; i < N - 1; i++) {
                if(arr[i + 1].startsWith(arr[i])) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
        in.close();
    }
    
}