import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int root;
	static ArrayList<Integer>[] arr;
	static int deleteNode;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N];
		for(int i=0; i<N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int par = Integer.parseInt(st.nextToken());
			if(par == -1) {
				root = i;
			} else {
				arr[par].add(i);
			}
		}
		deleteNode = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
			arr[i].remove(Integer.valueOf(deleteNode));
		}
		dfs(root);
		sb.append(cnt);
		System.out.println(sb);
	}
	
	public static void dfs(int nowNode) {
		if(nowNode == deleteNode) return;
		if(arr[nowNode].size() == 0) cnt++;
		for(int nextNode : arr[nowNode]) {
			dfs(nextNode);
		}
	}

}
