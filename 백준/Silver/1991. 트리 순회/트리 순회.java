import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] child;
	static StringBuilder sb = new StringBuilder();
	
	static void in_order(int x) {
		if(x == -1) return;
		in_order(child[x][0]);
		sb.append((char)(x + 'A'));
		in_order(child[x][1]);
	}
	
	static void pre_order(int x) {
		if(x == -1) return;
		sb.append((char)(x + 'A'));
		pre_order(child[x][0]);
		pre_order(child[x][1]);
	}
	
	static void post_order(int x) {
		if(x == -1) return;
		post_order(child[x][0]);
		post_order(child[x][1]);
		sb.append((char)(x + 'A'));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		child = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char curChar = st.nextToken().charAt(0);
			int cur = (int)(curChar - 'A');
			
			for(int j=0; j<2; j++) {
				char c = st.nextToken().charAt(0);
				if(c == '.') {
					child[cur][j] = -1;
				} else {
					child[cur][j] = (int)(c - 'A');
				}
			}
		}
		pre_order(0);
		sb.append("\n");
		in_order(0);
		sb.append("\n");
		post_order(0);
		System.out.println(sb);
	}
}
