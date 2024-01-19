import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(in.readLine());
        int[] nums = new int[M];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearchU(nums[i]) - binarySearchL(nums[i])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static int binarySearchL(int num) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start + end) / 2;
            if(num <= arr[mid]) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    static int binarySearchU(int num) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start + end) / 2;
            if(num < arr[mid]) end = mid;
            else start = mid + 1;
        }
        return end;
    }

}