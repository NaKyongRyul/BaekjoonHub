import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] inputArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		inputArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputArr);
//		System.out.println(Arrays.toString(inputArr));
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int findNum = Arrays.binarySearch(inputArr, Integer.parseInt(st.nextToken()));
			if(findNum < 0) {
				sb.append(0 + "\n");
			}
			else {
				sb.append(1 + "\n");
			}
		}
		System.out.println(sb);
	}

}
