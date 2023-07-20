import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (a,b) -> (a[1] != b[1]) ? (a[1] - b[1]) : (a[0] - b[0]));
		//System.out.println(Arrays.deepToString(arr));
		
		int nowTime = 0;
		for(int i=0; i<N; i++) {
			if(nowTime <= arr[i][0]) {
				nowTime = arr[i][1];
				ans++;
			}
		}
		sb.append(ans);
		System.out.println(sb);
	}
}
