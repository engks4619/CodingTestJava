import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] board, A;
    static List<Tree> treeList = new ArrayList<>();
    static Queue<Integer> deadTreeIdxQueue = new ArrayDeque<>();
    static int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initBoard();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        treeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            treeList.add(new Tree(x - 1, y - 1, z));
        }
        treeList.sort(Comparator.comparingInt(o -> o.age));
        for (int time = 0; time < K; time++) {
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(treeList.size());
        in.close();
    }

    static void spring() {
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);
            if(board[tree.r][tree.c] >= tree.age) {
                board[tree.r][tree.c] -= tree.age;
                tree.age++;
            }
            else deadTreeIdxQueue.offer(i);
        }
    }

    static void summer() {
        while(!deadTreeIdxQueue.isEmpty()) {
            int idx = deadTreeIdxQueue.poll();
            Tree tree = treeList.get(idx);
            board[tree.r][tree.c] += tree.age / 2;
            tree.isLive = false;
        }
    }

    static void fall() {
        List<Tree> newTreeList = new ArrayList<>();
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);
            if(!tree.isLive) continue;
            if(tree.age % 5 == 0) {
                for (int d = 0; d < dr.length; d++) {
                    int nr = tree.r + dr[d];
                    int nc = tree.c + dc[d];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    newTreeList.add(new Tree(nr, nc, 1));
                }
            }
        }
        for(Tree tree : treeList) {
            if(tree.isLive) newTreeList.add(tree);
        }
        treeList = newTreeList;
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] += A[i][j];
            }
        }
    }

    static void initBoard() {
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], 5);
        }
    }

    static class Tree {
        int r;
        int c;
        int age;
        boolean isLive;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
            this.isLive = true;
        }

    }
}