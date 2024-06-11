import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int islandCnt = 1;
    static int[][] board;
    static int[] parents;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numberingIsland();

        parents = new int[islandCnt];
        for (int i = 1; i < islandCnt; i++) {
            parents[i] = i;
        }

        PriorityQueue<Node> pq = getBridgePQ();
        System.out.println(getDistSum(pq));
        in.close();
    }

    static int getDistSum(PriorityQueue<Node> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if(find(node.from) != find(node.to)) {
                sum += node.dist;
                union(node.from, node.to);
            }
        }
        int parent = parents[1];
        for (int i = 1; i < islandCnt; i++) {
            if(parent != find(parents[i]))
                return -1;
        }
        return sum;
    }

    static void numberingIsland() {
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1 && !visited[i][j]) {
                    bfsForNumbering(i, j, visited);
                    islandCnt++;
                }
            }
        }
    }

    static void bfsForNumbering(int sR, int sC, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        visited[sR][sC] = true;
        board[sR][sC] = islandCnt;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M
                        || visited[nr][nc] || board[nr][nc] != 1) continue;
                board[nr][nc] = islandCnt;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }

    static PriorityQueue<Node> getBridgePQ() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != 0)
                    makeBridge(i, j, pq);
            }
        }
        return pq;
    }

    static void makeBridge(int sR, int sC, PriorityQueue<Node> pq) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int idx = board[sR][sC];
        for (int d = 0; d < dr.length; d++) {
            queue.offer(new int[] {sR, sC, 0});
            visited[sR][sC] = true;

            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int dist = curr[2];
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
                    continue;
                if(board[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc, dist + 1});
                }
                else if(board[nr][nc] != idx) {
                    if(dist >= 2)
                        pq.offer(new Node(idx, board[nr][nc], dist));
                    break;
                }
            }
            queue.clear();
        }

    }

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int dist;

        public Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

}