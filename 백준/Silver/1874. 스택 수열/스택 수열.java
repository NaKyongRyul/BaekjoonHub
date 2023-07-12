import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		Stack <Integer> stack = new Stack<>();

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int index = 1;
		
		for(int i=0; i<N; i++) {
			int now = arr[i];
			
			if(stack.isEmpty() || now > stack.peek()) {
				for(int j=index; j<=now; j++) {
					stack.push(j);
					sb.append("+" + "\n");
					index++;
				}
				stack.pop();
				sb.append("-" + "\n");
			}
			else if(now == stack.peek()) {
				stack.pop();
				sb.append("-" + "\n");
			}
			else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}
}