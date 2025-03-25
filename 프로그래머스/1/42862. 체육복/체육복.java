class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = 1;
        }
        
        for(int num : lost) {
            arr[num-1] = 0;
        }
        
        for(int num : reserve) {
            arr[num-1]++;
        }

        for(int i=0; i<n; i++) {
            if(arr[i] > 1) {
                if(i > 0 && arr[i-1] == 0) {
                    arr[i]--;
                    arr[i-1]++;
                } else if(i < n-1 && arr[i+1] == 0) {
                    arr[i]--;
                    arr[i+1]++;
                }
            }
        }
        
        int answer = 0;     
        for(int num : arr) {
            if(num > 0) {
                answer++;
            }
        }
        return answer;
    }
}