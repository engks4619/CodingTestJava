import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int answer = -1;
            for(int j = x; j < M*N; j += M){
                if(j % N == y){
                    answer = j + 1;
                    break;
                }
            }
            System.out.println(answer);
        }
        in.close();
    }
}
