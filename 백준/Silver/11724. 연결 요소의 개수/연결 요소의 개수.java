import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int count;
	static boolean[] visit;
	
	static void dfs(int x) {
		visit[x] = true;
		for(int y : arr[x]) {
			if(!visit[y]) {
				dfs(y);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		arr = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				dfs(i);
				count++;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
	}
}
