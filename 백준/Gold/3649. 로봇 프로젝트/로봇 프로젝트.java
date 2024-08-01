import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = in.readLine();
            if(input == null || !isNumeric(input)) break;
            int x = Integer.parseInt(input) * 10000000;
            int N = Integer.parseInt(in.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(in.readLine());
            }
            Arrays.sort(arr);
            int l = 0;
            int r = N - 1;
            boolean isFound = false;
            while(l < r) {
                int sum = arr[l] + arr[r];
                if(sum == x) {
                    isFound = true;
                    sb.append("yes ").append(arr[l]).append(" ").append(arr[r]).append("\n");
                    break;
                }
                else if(sum < x) l++;
                else r--;
            }
            if(!isFound) sb.append("danger").append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}