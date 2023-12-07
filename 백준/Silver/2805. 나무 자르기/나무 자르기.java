import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] treeArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        treeArr = new int[N];
        int tallestTree = 0;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
            tallestTree = Math.max(tallestTree, treeArr[i]);
        }
        System.out.println(getMaxHeight(0, tallestTree));
        in.close();
    }

    static int getMaxHeight(int l, int r){
        while(l < r){
            int mid = (l + r) / 2;
            long gettableTreeCnt = 0;
            for(int tree : treeArr){
                int length = tree - mid;
                gettableTreeCnt += length > 0 ? length : 0;
            }
            if(gettableTreeCnt < M){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l - 1;
    }
}