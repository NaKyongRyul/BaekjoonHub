class Solution {
    static boolean[] isVisit;
    static int count = 0;
    public int solution(int k, int[][] dungeons) {
        isVisit = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }
    
    public void dfs(int depth, int now_tired, int[][] dungeons) {
        for(int i=0; i<dungeons.length; i++) {
            if(isVisit[i] || dungeons[i][0] > now_tired) continue;
            isVisit[i] = true;
            dfs(depth + 1, now_tired - dungeons[i][1], dungeons);
            isVisit[i] = false;
        }
        count = Math.max(count, depth);
    }
}