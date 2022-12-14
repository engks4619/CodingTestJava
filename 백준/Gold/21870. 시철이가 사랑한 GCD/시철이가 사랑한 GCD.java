import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(function(data));
        in.close();
    }

    public static int function(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        int mid = arr.length / 2;
        return Math.max(function(Arrays.copyOfRange(arr,0,mid)) + getGcdFromList(Arrays.copyOfRange(arr,mid, arr.length)),
                function(Arrays.copyOfRange(arr, mid, arr.length)) + getGcdFromList(Arrays.copyOfRange(arr,0,mid)));
    }

    public static int getGcdFromList(int[] arr) {
        int a = arr[0];
        for(int b : Arrays.copyOfRange(arr, 1, arr.length)){
            a = gcd(a, b);
        }
        return a;
    }

    public static int gcd(int a, int b) {
        while(b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}