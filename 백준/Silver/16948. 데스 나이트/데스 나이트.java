import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, cnt;
    static Point start, goal;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        goal = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        if(!go()) cnt = -1;
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean go(){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(start);
        visited[start.r][start.c] = true;
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            if(curr.r == goal.r && curr.c == goal.c) {
                cnt = curr.cnt;
                return true;
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N
                        || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc, curr.cnt + 1));
            }
        }
        return false;
    }

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
            this.cnt = 0;
        }

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}