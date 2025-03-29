class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    static void dfs(int depth, int sum, int[] numbers, int target) {
        if(numbers.length == depth) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        dfs(depth+1, sum+numbers[depth], numbers, target);
        dfs(depth+1, sum-numbers[depth], numbers, target);
    }
}