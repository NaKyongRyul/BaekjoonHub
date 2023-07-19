import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int [] time = new int[100001];

	public static void bfs(int x) {	
		Queue<Integer> que = new LinkedList<>();	
		que.add(N);
//		time[N] = 0;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == K) return;
			
			// 1). X + 1 
			if( (now + 1) >= 0 && (now + 1) < 100001 && time[now + 1] == 0 ) {
				que.add(now + 1);
				time[now + 1] = time[now] + 1;
			}
			
			// 2). X - 1
			if( (now - 1) >= 0 && (now - 1) < 100001 && time[now - 1] == 0) {
				que.add(now - 1);
				time[now - 1] = time[now] + 1;
			}
			
			// 3). X*2 연산
			if( (now*2) >= 0 && (now*2) < 100001 && time[now * 2] == 0) {
				que.add(now*2);
				time[now*2] = time[now] + 1;
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		sb.append(time[K]);
		System.out.println(sb);
	}

}
