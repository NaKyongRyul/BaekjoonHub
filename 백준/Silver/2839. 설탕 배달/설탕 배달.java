import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, ans;
	static int remain;
	
	static void cal() {
		if(N%5 == 0) {
			ans = N/5;
		}
		else {
			for(int i=N/5; i>=0; i--) {
				ans = i;
				remain = N-5*i;
				if(remain%3 == 0) {
					ans += remain/3;
					return;
				} 
			}
			ans = -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		cal();
		sb.append(ans);
		System.out.println(sb);
	}
}