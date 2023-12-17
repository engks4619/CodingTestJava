import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] posArr = new int['z' - 'a' + 1];
        Arrays.fill(posArr, -1);
        String str = in.readLine();
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(posArr[idx] != -1) continue;
            posArr[idx] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int pos : posArr){
            sb.append(pos).append(" ");
        }
        System.out.println(sb);
        in.close();
    }
}