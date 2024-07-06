import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minSet = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            minSet = Math.min(minSet, Integer.parseInt(st.nextToken()));
            minEach = Math.min(minEach, Integer.parseInt(st.nextToken()));
        }
        int minPrice = minSet * (N % 6 == 0 ? N / 6 : N / 6 + 1);
        minPrice = Math.min(minPrice, minEach * N);
        minPrice = Math.min(minPrice, minSet * (N / 6) + minEach * (N % 6));
        System.out.println(minPrice);
        in.close();
    }
}