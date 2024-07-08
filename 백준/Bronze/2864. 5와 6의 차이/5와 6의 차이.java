import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String strA = st.nextToken();
        String strB = st.nextToken();
        int maxA = getNumber(strA, "MAX");
        int minA = getNumber(strA, "MIN");
        int maxB = getNumber(strB, "MAX");
        int minB = getNumber(strB, "MIN");
        int max = maxA + maxB;
        int min = minA + minB;
        System.out.println(min + " " + max);
        in.close();
    }

    static int getNumber(String str, String type) {
        StringBuilder strNum = new StringBuilder();
        for (char c : str.toCharArray()) {
            if(type.equals("MAX")) strNum.append(c == '5' ? '6' : c);
            else if(type.equals("MIN")) strNum.append(c == '6' ? '5' : c);
        }
        return Integer.parseInt(strNum.toString());
    }
}