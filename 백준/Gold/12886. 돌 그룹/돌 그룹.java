import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int answer = bfs(A, B, C) ? 1 : 0;
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean bfs(int sA, int sB, int sC){
        Queue<Stone> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[1501][1501];
        queue.offer(new Stone(sA, sB, sC));
        visited[sA][sB] = true;
        while(!queue.isEmpty()){
            Stone curr = queue.poll();
            if(curr.A == curr.B && curr.B == curr.C) return true;
            if(curr.A != curr.B) {
                int nA = curr.A > curr.B ? curr.A - curr.B : curr.A * 2;
                int nB = curr.A > curr.B ? curr.B * 2 : curr.B - curr.A;
                if(visited[nA][nB]) continue;
                visited[nA][nB] = true;
                queue.offer(new Stone(nA, nB, curr.C));
            }
            if(curr.B != curr.C) {
                int nB = curr.B > curr.C ? curr.B - curr.C : curr.B * 2;
                int nC = curr.B > curr.C ? curr.C * 2 : curr.C - curr.B;
                if(visited[nB][nC]) continue;
                visited[nB][nC] = true;
                queue.offer(new Stone(curr.A, nB, nC));
            }
            if(curr.A != curr.C) {
                int nA = curr.A > curr.C ? curr.A - curr.C : curr.A * 2;
                int nC = curr.A > curr.C ? curr.C * 2 : curr.C - curr.A;
                if(visited[nA][nC]) continue;
                visited[nA][nC] = true;
                queue.offer(new Stone(nA, curr.B, nC));
            }
        }
        return false;
    }

    static class Stone {
        int A;
        int B;
        int C;

        public Stone(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }

}