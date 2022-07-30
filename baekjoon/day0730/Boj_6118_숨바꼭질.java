package baekjoon.day0730;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_6118_숨바꼭질 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> adjList[] = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        distance[0] = -1;
        visited[1] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1, 0});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int curr = point[0];
            int dist = point[1];
            for(Integer next : adjList[curr]){
                if(!visited[next]){
                    visited[next] = true;
                    distance[next] = dist + 1;
                    queue.offer(new int[] {next, dist + 1});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int answer = 0;
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(distance[i] > max){
                count = 1;
                max = distance[i];
                answer = i;
            } else if (distance[i] == max) {
                count++;
            }
        }
        System.out.println(answer+" "+max+" "+count);
        in.close();
    }
}
