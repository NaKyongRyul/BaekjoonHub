import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue <Integer> que = new ArrayDeque<>();

		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		sb.append("<");
		for(int i=0; i<N; i++) {
			for(int j=1; j<K; j++) {
				que.add(que.poll());
			}
			int result = que.poll();
			
			if(que.size() == 0) {
				sb.append(result);
			} else {
				sb.append(result + ", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}

}
