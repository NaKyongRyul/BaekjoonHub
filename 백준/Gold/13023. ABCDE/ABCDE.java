import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static boolean[] isVisited;
	static int ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N];
		for(int i=0; i<N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
		for(int i=0; i<N; i++) {
			isVisited = new boolean[N];
			dfs(i, 1);
		}
		sb.append(ans);
		System.out.println(sb);
	}
	
	static void dfs(int now, int count) {
		if(count >= 5 || ans == 1) {
			ans = 1;
			return;
		}
		isVisited[now] = true;
		
		for(int nextNode : arr[now]) {
			if(!isVisited[nextNode]) {
				dfs(nextNode, count+1);
				isVisited[nextNode] = false;
			}
		}
	}

}
