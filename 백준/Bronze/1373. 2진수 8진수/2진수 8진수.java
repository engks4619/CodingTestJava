import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String num = in.readLine();
        if(num.length() % 3 == 1){
            num = "00" + num;
        } else if (num.length() % 3 == 2) {
            num = "0" + num;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i += 3) {
            String str = num.substring(i, i + 3);
            int tmp = 0;
            for (int j = 0; j < str.length(); j++) {
                tmp += str.charAt(j) == '1' ? Math.pow(2, 2 - j) : 0;
            }
            sb.append(tmp);
        }
        System.out.println(sb);
        in.close();
    }
}