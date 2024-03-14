import java.util.*;

// 선물 지수가 크면 선물받음
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] history = new int[n][n]; // 선물 내역 
        int[] nextMonthGift = new int[n]; // 다음 달 받을 선물
        int[] giftScore = new int[n]; // 선물 지수
        Map<String, Integer> friendsIdx = new HashMap<>(); // 친구들 인덱스
        
        for(int i=0; i<n; i++) {
            friendsIdx.put(friends[i], i);
        }
        
        for(String str : gifts) {
            String[] space = str.split(" "); 
            int giverIdx = friendsIdx.get(space[0]);
            int takerIdx = friendsIdx.get(space[1]);
            history[giverIdx][takerIdx]++;
            giftScore[giverIdx]++;
            giftScore[takerIdx]--;
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int give = history[i][j];
                int take = history[j][i];
                
                if(give > take) {
                    nextMonthGift[i]++;
                } else if(give < take) {
                    nextMonthGift[j]++;
                } else {
                    if(giftScore[i] > giftScore[j]) {
                        nextMonthGift[i]++;
                    } else if(giftScore[i] < giftScore[j]) {
                        nextMonthGift[j]++;
                    }
                }
            }
        }
        return Arrays.stream(nextMonthGift).max().getAsInt();
    }
}