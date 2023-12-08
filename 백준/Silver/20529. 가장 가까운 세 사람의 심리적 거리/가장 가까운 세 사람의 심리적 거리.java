import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            sb.append(go(N, st)).append("\n");
        }
        System.out.println(sb.toString().trim());
        in.close();
    }

    static int go(int N, StringTokenizer st){
        if(N > 32){
            return 0;
        }
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        int minDistanceSum  = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    minDistanceSum = Math.min(minDistanceSum , getDistanceSum(arr[i], arr[j], arr[k]));
                }
            }
        }
        return minDistanceSum;
    }

    static int getDistanceSum(String a, String b, String c){
        int sum = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) sum++;
            if(b.charAt(i) != c.charAt(i)) sum++;
            if(c.charAt(i) != a.charAt(i)) sum++;
        }
        return sum;
    }

}