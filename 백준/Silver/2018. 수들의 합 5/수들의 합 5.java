import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//투포인터 
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;		
		int start = 1;
		int end = 1;
		int sum = 1;
		
		while(end != N) {
			if(sum < N) {
				sum += ++end;
			} else if(sum > N) {
				sum -= start++;
			} else {
				count++;
				sum -= start++;
			}
		}
		System.out.println(count+1);
	}

}
