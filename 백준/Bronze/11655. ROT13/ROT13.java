import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(char c : in.readLine().toCharArray()){
            sb.append(ROT13(c));
        }
        System.out.println(sb);
        in.close();
    }

    static char ROT13(char c){
        if('a' <= c && c <= 'z') return (char) (c + 13 > 'z' ? c - 13 : c + 13);
        else if('A' <= c && c <= 'Z') return (char) (c + 13 > 'Z' ? c - 13 : c + 13);
        else return c;
    }
}