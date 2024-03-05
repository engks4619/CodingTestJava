import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S = in.readLine();
        String P = in.readLine();
        System.out.println(KMP(S, P)? "1" : "0");
        in.close();
    }

    static boolean KMP(String S, String P) {
        int[] table = makeTable(P);
        boolean isFound = false;
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            while(j > 0 && S.charAt(i) != P.charAt(j)) {
                j = table[j - 1];
            }
            if(S.charAt(i) == P.charAt(j)) {
                if(j == P.length() - 1) {
                    isFound = true;
                    break;
                }
                else j++;
            }
        }
        return isFound;
    }

    static int[] makeTable(String P) {
        int[] table = new int[P.length()];
        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j)){
                j = table[j - 1];
            }
            if(P.charAt(i) == P.charAt(j)){
                table[i] = ++j;
            }
        }
        return table;
    }

}