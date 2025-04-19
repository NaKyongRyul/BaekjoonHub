import java.util.*;

class Solution {
    public int[] solution(String[] operations) {        
        int[] answer = {};
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        
        for(int i=0; i<operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            if(c == 'I') {
                minQueue.add(num);
                maxQueue.add(num);
            } else if(c == 'D') {
                if(minQueue.isEmpty() || maxQueue.isEmpty()) continue;
                if(num == 1) {
                    int n = maxQueue.poll();
                    minQueue.remove(n);
                } else if(num == -1) {
                    int n = minQueue.poll();
                    maxQueue.remove(n);
                }
            }
        }
        if(minQueue.isEmpty() || maxQueue.isEmpty()) {
            answer = new int[] {0,0};
            return answer;
        }
        answer = new int[] {maxQueue.peek(), minQueue.peek()};
        return answer;
    }
}