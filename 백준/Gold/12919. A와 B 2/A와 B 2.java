import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder S, T;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = new StringBuilder(in.readLine());
        T = new StringBuilder(in.readLine());
        String answer = go(T.toString()) ? "1" : "0";
        bw.write(answer);
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean go(String T) {
        if(S.length() == T.length()){
            if(T.equals(S.toString())){
                return true;
            }
            return false;
        }
        if(T.charAt(T.length() - 1) == 'A') {
            if(go(T.substring(0, T.length() - 1))) return true;
        }
        if(T.charAt(0) == 'B') {
            if(go(new StringBuilder(T).reverse().deleteCharAt(T.length() - 1).toString())) return true;
        }
        return false;
    }
}