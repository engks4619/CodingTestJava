import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        while(m-- > 0){
            num += Integer.parseInt(st.nextToken()) * Math.pow(A, m);
        }
        if(num == 0) stack.add(0);
        while(num != 0){
            int r = num % B;
            num /= B;
            stack.add(r);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
        in.close();
    }
}