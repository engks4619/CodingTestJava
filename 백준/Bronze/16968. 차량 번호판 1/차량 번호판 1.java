import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = in.readLine();
        int answer = 1;
        char prev = ' ';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == prev) answer *= c == 'd' ? 9 : 25;
            else answer *= c == 'd' ? 10 : 26;
            prev = c;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

}