import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int year = 1;
        while(true){
            boolean flagE = year % 15 == E || (E == 15 && year % 15 == 0);
            boolean flagS = year % 28 == S || (S == 28 && year % 28 == 0);
            boolean flagM = year % 19 == M || (M == 19 && year % 19 == 0);
            if(flagE && flagM && flagS) break;
            year++;
        }
        System.out.println(year);
        in.close();
    }
}