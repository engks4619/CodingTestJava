import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[] {"000", "001", "010", "011", "100", "101", "110", "111"};
        String str = in.readLine();
        for(char c : str.toCharArray()){
            int num = Integer.parseInt(c+"");
            sb.append(arr[num]);
        }
        while(sb.length() > 1){
            if(sb.charAt(0) == '1') break;
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
        in.close();
    }
}