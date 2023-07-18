import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;//정점의 개수 
	static int M;//간선의 개수 
	static int V;//탐색을 시작할 정점의 번호 
	static boolean[] visit;//해당노드 방문여부(마킹배열)  
	static ArrayList<Integer>[] arr;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int x) {
		visit[x] = true;
		sb.append(x + " ");
		for(int y : arr[x]) {
			if(!visit[y]) {
				dfs(y);
			}
		}
	}
	
	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		que.add(x);	
		visit[x] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now + " ");
			
			for(int y : arr[now]) {
				if(!visit[y]) {
					que.add(y);
					visit[y] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		visit = new boolean[N+1];
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
		
		for(int i=0; i<=N; i++) {
			Collections.sort(arr[i]);
		}
		
		dfs(V);
		sb.append('\n');
		visit = new boolean[N+1];//마킹배열 초기화 
		bfs(V);
		
		System.out.println(sb);
	}

}
