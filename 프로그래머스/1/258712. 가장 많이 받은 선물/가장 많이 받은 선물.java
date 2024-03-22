import java.util.*;

class Solution {
    
    static Map<String, Integer> friendMap = new HashMap<>();
    static Map<String, Integer> scoreMap = new HashMap<>();
    static int N;
    static int[][] giftLogArr;
    static int[] giftCntArr;
    static int[] giftScoreArr;
    
    public int solution(String[] friends, String[] gifts) {
        N = friends.length;
        giftLogArr = new int[N][N];
        giftCntArr = new int[N];
        giftScoreArr = new int[N];
        for(int i = 0; i < N; i++) {
            friendMap.put(friends[i], i);
        }
        
        for(String name : friends) {
            scoreMap.put(name, 0);
        }
        
        for(String str : gifts) {
            String[] gift = str.split(" ");
            go(gift[0], gift[1]);
        }
        
        return getMaxCnt();
    }
    
    static void go(String from, String to) {
        int f = friendMap.get(from);
        int t = friendMap.get(to);
        giftLogArr[f][t]++;
        giftScoreArr[f]++;
        giftScoreArr[t]--;
    }
    
    static int getMaxCnt() {
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                updateCnt(i, j);
            }
        }
        int maxCnt = 0;
        for(int i = 0; i < N; i++) {
            maxCnt = Math.max(maxCnt, giftCntArr[i]);
        }
        return maxCnt;   
    }
    
    static void updateCnt(int i, int j) {
        if(giftLogArr[i][j] > giftLogArr[j][i]) giftCntArr[i]++;
        else if(giftLogArr[i][j] < giftLogArr[j][i]) giftCntArr[j]++;
        else {
            if(giftScoreArr[i] > giftScoreArr[j]) giftCntArr[i]++;
            else if(giftScoreArr[i] < giftScoreArr[j]) giftCntArr[j]++;
        }
    }
    
}