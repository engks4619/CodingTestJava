import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] cntArr = new int['z' - 'a' + 1];
        for(char c : in.readLine().toCharArray()){
            cntArr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int cnt : cntArr){
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
        in.close();
    }
}