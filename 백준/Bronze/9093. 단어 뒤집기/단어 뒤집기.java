import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            while(st.hasMoreTokens()){
                StringBuilder word = new StringBuilder(st.nextToken());
                word.reverse();
                sb.append(word).append(" ");
            }
            if(sb.length() > 0) sb.setLength(sb.length()-1);
            sb.append("\n");
        }
        if(sb.length() > 0) sb.setLength(sb.length()-1);
        System.out.println(sb);
        in.close();
    }
}