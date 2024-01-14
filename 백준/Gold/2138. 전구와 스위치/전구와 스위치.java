import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, result = Integer.MAX_VALUE;
    static boolean[] originArr, targetArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        originArr = new boolean[N];
        targetArr = new boolean[N];
        String str = in.readLine();
        for (int i = 0; i < N; i++) {
            originArr[i] = str.charAt(i) == '1';
        }
        str = in.readLine();
        for (int i = 0; i < N; i++) {
            targetArr[i] = str.charAt(i) == '1';
        }
        go();
        bw.write(result == Integer.MAX_VALUE ? -1 + "\n" : result + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go() {
        boolean[] arr = originArr.clone();
        arr[0] = !arr[0];
        arr[1] = !arr[1];
        int cnt = getCnt(arr, 1);
        if(isSameArr(arr, targetArr)) result = Math.min(result, cnt);

        arr = originArr.clone();
        cnt = getCnt(arr, 0);
        if(isSameArr(arr, targetArr)) result = Math.min(result, cnt);
    }

    static int getCnt(boolean[] arr, int cnt) {
        for (int i = 1; i < N; i++) {
            if(arr[i - 1] != targetArr[i - 1]) {
                arr[i - 1] = !arr[i - 1];
                arr[i] = !arr[i];
                if(i + 1 < N) arr[i + 1] = !arr[i + 1];
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isSameArr(boolean[] arr, boolean[] target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != target[i]) return false;
        }
        return true;
    }

}