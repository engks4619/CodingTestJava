import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] cntArr = new int[10];
        for (char c : in.readLine().toCharArray()) {
            int num = c - '0';
            if(num == 9 || num == 6) {
                if(cntArr[9] > cntArr[6]) cntArr[6]++;
                else if(cntArr[6] > cntArr[9]) cntArr[9]++;
                else cntArr[num]++;
                continue;
            }
            cntArr[num]++;
        }
        int maxCnt = 0;
        for (int cnt : cntArr) {
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
        in.close();
    }
}