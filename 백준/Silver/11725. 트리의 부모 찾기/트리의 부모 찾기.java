import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] arr;
	static int[] parent;
	
    public static void dfs(int x, int par) {
        for(int y : arr[x]) {
            if (y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
        dfs(1, -1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
	}
}
