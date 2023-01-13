import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<Integer>();
        list.add(data[0]);
        for(int i = 1; i < N; i++){
            int num = data[i];
            if(num > list.get(list.size()-1)){
                list.add(num);
                continue;
            }
            int idx = binarySearch(num);
            list.set(idx, num);
        }
        System.out.println(list.size());
        in.close();
    }

    public static int binarySearch(int num){
        int left = 0;
        int right = list.size()-1;
        int mid;
        while(left < right){
            mid = (left + right) / 2;
            if(list.get(mid) < num){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}