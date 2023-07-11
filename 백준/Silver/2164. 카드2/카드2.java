import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static int moveNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue <Integer> que = new ArrayDeque<>();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		while(que.size() > 1) {
			que.poll();
			moveNum = que.poll();
			que.offer(moveNum);
		}
		sb.append(que.peek());
		System.out.println(sb);
	}

}
