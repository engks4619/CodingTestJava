import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxScore = 0;
    static int N;
    static int[][] scoreBoard;
    static int R = 9;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        scoreBoard = new int[N][R];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < R; j++){
                scoreBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr = new int[R];
        visited = new boolean[R];
        //4번타자 첫번째 고정
        arr[3] = 0;
        visited[3] = true;
        permutation(1);
        System.out.println(maxScore);
        in.close();
    }

    // 순서 정하기 - 순열
    public static void permutation(int depth){
        if(depth == R){
            maxScore = Math.max(maxScore, calc(arr));
            return;
        }
        for(int i = 0; i < R; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[i] = depth;
            permutation(depth + 1);
            visited[i] = false;

        }
    }

    // 점수 계산
    public static int calc(int[] arr){
        int inning = 0;
        int score = 0;
        int sum = 1; //타석에 주자 배치
        int outCnt = 0;
        int idx = 0;
        int base = Integer.parseInt("11110000", 2);
        while(inning < N){
            int result = scoreBoard[inning][arr[idx++ % 9]];
            if(result == 0){
                if(++outCnt >= 3){
                    sum = 1;
                    outCnt = 0;
                    inning++;
                }
                continue;
            }
            sum <<= result; //기존 주자 진루
            sum |= 1; //타석에 주자 배치
            //점수계산
            int s = sum & base; // 올라갈 점수 비트마스킹
            sum &= ~base; // 올라갈 점수 빼주기
            for(int i = 4; i < 8; i++){
                if((s>>i & 0x1) == 1){
                    score++;
                }
            }

        }
        return score;
    }
}