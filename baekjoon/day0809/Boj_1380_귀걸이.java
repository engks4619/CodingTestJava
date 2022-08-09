package baekjoon.day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1380_귀걸이 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;
        while(tc++ >= 0){
            int N = Integer.parseInt(in.readLine());
            if (N == 0) break;
            Map<Integer, String> peopleMap = new HashMap<>();
            for(int i = 1; i <= N ; i++){
                peopleMap.put(i, in.readLine());
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < 2*N -1; i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)){
                    peopleMap.remove(num);
                }
                set.add(num);
            }
            String name = "";
            for(Integer key : peopleMap.keySet()){
                name = peopleMap.get(key);
            }
            sb.append(tc).append(" ").append(name).append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}
