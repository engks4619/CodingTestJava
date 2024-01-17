import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder S = new StringBuilder(in.readLine());
        StringBuilder T = new StringBuilder(in.readLine());
        
        while(true) {
            if(S.length() == T.length()) break;
            char lastChar = T.charAt(T.length() - 1);
            T.deleteCharAt(T.length() - 1);
            if (lastChar == 'B') {
                T.reverse();
            }
        }
        
        bw.write(T.toString().equals(S.toString()) ? "1" : "0");
        bw.flush();
        bw.close();
        in.close();
    }
}