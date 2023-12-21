import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }
        int answer = arr[0];
        for (int i = 1; i < N; i++) {
            answer = gcd(answer, arr[i]);
        }
        System.out.println(answer);
        in.close();
    }

    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}