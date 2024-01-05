import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int S;
    static boolean[][] visited = new boolean[2001][2001];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = Integer.parseInt(in.readLine());
        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static int bfs(){
        Queue<Node> queue = new ArrayDeque<>();
        Node start = new Node(1, 0, 0);
        queue.offer(start);
        visited[start.emoticonCnt][start.clipboardCnt] = true;
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            int eCnt = currNode.emoticonCnt;
            int cCnt = currNode.clipboardCnt;
            int time = currNode.time;

            if(eCnt == S) return time;
            if(eCnt <= 0 || eCnt >= 2000) continue;
            if(!visited[eCnt][eCnt]){
                visited[eCnt][eCnt] = true;
                queue.offer(new Node(eCnt, eCnt, time + 1));
            }
            if(!visited[eCnt - 1][cCnt]){
                visited[eCnt - 1][cCnt] = true;
                queue.offer(new Node(eCnt - 1, cCnt, time + 1));
            }
            if(cCnt <= 0 || eCnt + cCnt >= 2000) continue;
            if(!visited[eCnt + cCnt][cCnt]){
                visited[eCnt + cCnt][cCnt] = true;
                queue.offer(new Node(eCnt + cCnt, cCnt, time + 1));
            }
        }
        return -1;
    }

    static class Node{
        int emoticonCnt;
        int clipboardCnt;
        int time;

        public Node(int emoticonCnt, int clipboardCnt, int time) {
            this.emoticonCnt = emoticonCnt;
            this.clipboardCnt = clipboardCnt;
            this.time = time;
        }
    }
}