import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long[] sum;
	static long[] sumRemain;
	static long count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = new long[N+1];
		sumRemain = new long[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
			
			if(sum[i]%M==0) {
				count++;
			}
			sumRemain[(int)(sum[i]%M)]++;
		}
		
		for(int i=0; i<M; i++) {
			if(sumRemain[i]>1) {
				count += sumRemain[i]*(sumRemain[i]-1)/2;
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
}
