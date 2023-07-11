import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] conditionArr = new int[4];//조건 {A, C, G, T} 횟수 배열 
	static int[] realArr = new int[4];//실제 {A, C, G, T} 횟수 배열 
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] arr = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			conditionArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<P; i++) {
			if(arr[i] == 'A') realArr[0]++; 
			if(arr[i] == 'C') realArr[1]++;
			if(arr[i] == 'G') realArr[2]++;
			if(arr[i] == 'T') realArr[3]++;
		}
		
		if(check()) {
			count++;
		}
		
		for(int j=P; j<S; j++) {
			if(arr[j-P] == 'A') realArr[0]--;
			if(arr[j-P] == 'C') realArr[1]--;
			if(arr[j-P] == 'G') realArr[2]--;
			if(arr[j-P] == 'T') realArr[3]--;
			
			if(arr[j] == 'A') realArr[0]++;
			if(arr[j] == 'C') realArr[1]++;
			if(arr[j] == 'G') realArr[2]++;
			if(arr[j] == 'T') realArr[3]++;
			
			if(check()) {
				count++;
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
	
	public static boolean check() {
		for(int i=0; i<4; i++) {
			if(realArr[i] < conditionArr[i]) {
				return false;
			}
		}
		return true;
	}

}
