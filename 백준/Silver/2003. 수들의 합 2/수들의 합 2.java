import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

     public static void main(String[] args) throws Exception {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(in.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         int[] arr = new int[N + 1];
         st = new StringTokenizer(in.readLine());
         for (int i = 1; i <= N; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
             arr[i] += arr[i - 1];
         }
         int cnt = 0;
         for (int r = N; r > 0; r--) {
             for (int l = 0; l < r; l++) {
                if(arr[r] - arr[l] == M) cnt++;
             }
         }
         bw.write(cnt + "\n");
         bw.flush();
         bw.close();
         in.close();
     }
     
}