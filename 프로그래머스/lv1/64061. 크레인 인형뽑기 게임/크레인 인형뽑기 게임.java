import java.util.Stack;

public class Solution {

	public int solution(int[][] board, int[] moves) {
    	Stack<Integer> stack = new Stack<>();
    	stack.push(0);
    	
        int answer = 0;
    	
    	for(int i=0; i<moves.length; i++) {
        	for(int j=0; j<board.length; j++) {
        		if(board[j][moves[i]-1] != 0) {
        			if(stack.peek() != board[j][moves[i]-1]) {
        				stack.push(board[j][moves[i]-1]);
        			} else {
        				stack.pop();
        				answer += 2;
        			}
    				board[j][moves[i]-1] = 0;
    				break;
        		}
        	}
    	}
        return answer;
    }
}