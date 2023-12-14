import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        int cnt = 0;
        Character prev = null;
        for(Character c : in.readLine().toCharArray()){
            if(c == '('){
                prev = '(';
                size++;
                continue;
            }
            size--;
            if(prev == ')') cnt++;
            else cnt += size;
            prev = c;
        }
        System.out.println(cnt);
        in.close();
    }
}