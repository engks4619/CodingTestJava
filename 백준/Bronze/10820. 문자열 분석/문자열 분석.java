import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while((str = in.readLine()) != null && !str.isEmpty()){
            int lower = 0, upper = 0, number = 0, space = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(Pattern.matches("^[a-z]", c + "")) lower++;
                else if(Pattern.matches("^[A-Z]", c + "")) upper++;
                else if(Pattern.matches("^[0-9]", c + "")) number++;
                else if(c == ' ') space++;
            }
            sb.append(lower).append(" ")
                    .append(upper).append(" ")
                    .append(number).append(" ")
                    .append(space).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}