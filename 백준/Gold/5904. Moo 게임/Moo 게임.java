import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int totalLength = 3;
        int midLength= 3;
        while(N > totalLength){
            midLength++;
            totalLength = totalLength * 2 + midLength;
        }
        System.out.println(function(N, totalLength, midLength));
        in.close();
    }

    static char function(int idx, int total, int mid) {
        if(idx <= 3){
            if(idx == 1)
                return 'm';
            else
                return 'o';   
        }
        int left = (total - mid) / 2 + 1;
        int right = (total - mid) / 2 + mid + 1;
        if(idx < left) {
            return function(idx, left-1, mid-1);
        }else if (left <= idx && idx < right) {
            if(idx == left) 
                return 'm';
            else
                return 'o'; 
        }else {
            return function(idx-(right-1), total - (right-1), mid-1);
        }
    }
}