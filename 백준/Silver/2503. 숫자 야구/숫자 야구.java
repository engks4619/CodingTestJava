import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] arr = new boolean[1000];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for (int i = 123; i < 1000; i++) {
            String str = Integer.toString(i);
            if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') continue;
            if (str.charAt(0) == str.charAt(1)
                    || str.charAt(0) == str.charAt(2)
                    || str.charAt(1) == str.charAt(2))
                continue;
            arr[i] = true;
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            String str = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for (int num = 123; num < 1000; num++) {
                if (arr[num]) {
                    int s = 0;
                    int b = 0;
                    String strNum = Integer.toString(num);
                    for (int left = 0; left < 3; left++) {
                        for (int right = 0; right < 3; right++) {
                            if (str.charAt(left) == strNum.charAt(right) && left == right) s++;
                            else if (str.charAt(left) == strNum.charAt(right) && left != right) b++;
                        }
                    }
                    if (s == strike && b == ball) arr[num] = true;
                    else arr[num] = false;
                }
            }
        }
        int result = 0;
        for (boolean flag : arr) {
            if (flag) result++;
        }
        System.out.println(result);
        in.close();
    }
}