import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int N;
	static int[] parent;
	static int ans;
	static char[][] arr;
	static int weightSum;
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		//부모 배열 초기화 
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}	
				
		arr = new char[N][N];
		
		//입력한 문자열 
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		Queue<Edge> que = new PriorityQueue<>();		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] >= 'a' && arr[i][j] <= 'z') {
					weightSum += arr[i][j] - 96;
					que.add(new Edge(i+1, j+1, arr[i][j]-96));			
				} else if(arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
					weightSum += arr[i][j] - 38;
					que.add(new Edge(i+1, j+1, arr[i][j]-38));
				}
			}
		}
		
		int unionCnt = 0;
		
		//여기서 size변수에 집어넣지 않고 for문에 que.size()를 넣으면 
		//poll()할 때마다 크기가 줄어드므로 맞지 않다. 
		int size = que.size();
		for(int i=0; i<size; i++) {
			Edge edge = que.poll();
			
			//부모가 같은 노드끼리 연결하면 사이클을 형성하므로 그렇지 않아야지 연결 
			if(find(edge.node1) != find(edge.node2)) { 
				union(edge.node1, edge.node2);
				ans += edge.weight;
				unionCnt++;
			}
		}
		if(unionCnt != (N-1)) {
			sb.append(-1);
		} else {
			sb.append(weightSum - ans);
		}
		System.out.println(sb);
	}
}

class Edge implements Comparable<Edge>{
	int node1, node2, weight;
	Edge(int node1, int node2, int weight) {
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}
	//가중치 기준으로 오름차순 정렬 
	@Override
	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}
}