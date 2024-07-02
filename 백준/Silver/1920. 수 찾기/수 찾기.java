import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(key) ? 1 : 0).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static boolean binarySearch(int key) {
        int left = 0;
        int right = N - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] < key) left = mid + 1;
            else if(arr[mid] > key) right = mid - 1;
            else return true;
        }
        return false;
    }

}