import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, maxValue = Integer.MIN_VALUE;
    static String[] originArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        originArr = new String[N];
        String str = in.readLine();
        for (int i = 0; i < N; i++) {
            originArr[i] = str.charAt(i) + "";
        }
        int opCnt = N / 2;
        int maxCnt = opCnt % 2 == 0 ? opCnt / 2 : opCnt / 2 + 1;
        for (int i = 0; i <= maxCnt; i++) {
            go(0, 1, i, new Integer[i]);
        }
        bw.write(maxValue + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int cnt, int start, int maxCnt, Integer[] selected) {
        if(cnt == maxCnt) {
            updateValue(selected);
            return;
        }

        for (int i = start; i < N; i += 2) {
            if(cnt > 0 && selected[cnt - 1] == i - 2) continue;  // 연속된 괄호 불가능
            selected[cnt] = i;
            go(cnt + 1, i + 2, maxCnt, selected);
        }

    }

    static void updateValue(Integer[] selected) {
        String[] arr = originArr.clone();
        //괄호
        for (int i = 0; i < selected.length; i++) {
            int idx = selected[i];
            if(idx != 0) {
                int a = Integer.parseInt(arr[idx - 1]);
                int b = Integer.parseInt(arr[idx + 1]);
                int res = calculate(a, b, arr[idx]);
                arr[idx] = res + "";
                arr[idx - 1] = null;
                arr[idx + 1] = null;
            }
        }
        //곱하기
        for (int idx = 1; idx < N; idx += 2) {
            if(arr[idx] == null || !arr[idx].equals("*")) continue;
            int l = idx - 1;
            int r = idx + 1;
            while(arr[l] == null) l--;
            while(arr[r] == null) r++;
            int a = Integer.parseInt(arr[l]);
            int b = Integer.parseInt(arr[r]);
            int res = calculate(a, b, arr[idx]);
            arr[idx] = res + "";
            arr[l] = null;
            arr[r] = null;
        }
        //나머지
        for (int idx = 1; idx < N; idx += 2) {
            if(arr[idx] == null || !(arr[idx].equals("+") || arr[idx].equals("-"))) continue;
            int l = idx - 1;
            int r = idx + 1;
            while(arr[l] == null) l--;
            while(arr[r] == null) r++;
            int a = Integer.parseInt(arr[l]);
            int b = Integer.parseInt(arr[r]);
            int res = calculate(a, b, arr[idx]);
            arr[idx] = res + "";
            arr[l] = null;
            arr[r] = null;
        }
        //총합
        int val = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] == null) continue;
            val += Integer.parseInt(arr[i]);
        }
        maxValue = Math.max(maxValue, val);
    }

    static int calculate(int a, int b, String op) {
        switch (op) {
            case "*" :
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                return 0;
        }
    }

}