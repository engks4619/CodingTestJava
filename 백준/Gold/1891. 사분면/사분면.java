import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int d, arr[];
    static long originR, originC;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        d = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        arr = new int[d];
        for (int i = 0; i < d; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        st = new StringTokenizer(in.readLine());
        long c = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        long size = 1L << d;
        findPos(0, 0, 0, size, size);
        long nr = originR - r;
        long nc = originC + c;
        if(nr >= 0 && nr < size && nc >= 0 && nc < size) findStr(d, nr, nc);
        else sb.append(-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void findPos(int depth, long lr, long lc, long rr, long rc) {
        if(depth == d) {
            originR = lr;
            originC = lc;
            return;
        }
        int num = arr[depth];
        switch (num) {
            case 1 :
                findPos(depth + 1, lr, (lc + rc) / 2, (lr + rr) / 2, rc);
                break;
            case 2 :
                findPos(depth + 1, lr, lc, (lr + rr) / 2, (lc + rc) / 2);
                break;
            case 3 :
                findPos(depth + 1, (lr + rr) / 2, lc, rr, (lc + rc) / 2);
                break;
            case 4 :
                findPos(depth + 1, (lr + rr) / 2, (lc + rc) / 2, rr, rc);
                break;
        }
    }

    static void findStr(int depth, long r, long c) {
        if(depth == 0) return;

        long size = 1L << (depth - 1);
        if(r < size && c >= size) {
            sb.append(1);
            findStr(depth - 1, r, c - size);
        } else if(r < size && c < size) {
            sb.append(2);
            findStr(depth - 1, r, c);
        } else if(r >= size && c < size) {
            sb.append(3);
            findStr(depth - 1, r - size, c);
        } else if(r >= size && c >= size){
            sb.append(4);
            findStr(depth - 1, r - size, c - size);
        }

    }

}