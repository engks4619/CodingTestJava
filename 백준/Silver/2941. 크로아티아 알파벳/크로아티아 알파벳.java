import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'c' && i < str.length() - 1 && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
                cnt++;
                i++;
            }
            else if(c == 'd' && i < str.length() - 2 && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                cnt++;
                i += 2;
            }
            else if(c == 'd' && i < str.length() - 1 && str.charAt(i + 1) == '-') {
                cnt++;
                i++;
            }
            else if((c == 'l' || c == 'n') && i < str.length() - 1 && str.charAt(i + 1) == 'j') {
                cnt++;
                i++;
            }
            else if((c == 's' || c == 'z') && i < str.length() - 1 && str.charAt(i + 1) == '=') {
                cnt++;
                i++;
            }
            else cnt++;

        }
        System.out.println(cnt);
        in.close();
    }
}