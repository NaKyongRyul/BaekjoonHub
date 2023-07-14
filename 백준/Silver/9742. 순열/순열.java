import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N;
	static String S;
	static int count;
	static int[] used;
	static char[] charArr;
    
	public static void rec_func(int k) {
		if(k == charArr.length) {
			count++;
			if(count == N) {
    			System.out.println(S + " " + N + " = " + sb.toString());
			}
			return;
		} else {
			for(int cand=0; cand<charArr.length; cand++) {
				if(used[cand] == 1) {
					continue;
				}
				sb.append(charArr[cand]);
				used[cand] = 1;
				rec_func(k+1);
				used[cand] = 0;
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	String line;
    	
    	while((line = br.readLine()) != null) {
    		st = new StringTokenizer(line);
    		S = st.nextToken();
    		N = Integer.parseInt(st.nextToken());
    		
    		count = 0;
    		sb = new StringBuilder();
    		charArr = S.toCharArray();
    		used = new int[charArr.length];
    		rec_func(0);
    		
    		if(count < N) {
    			System.out.println(S + " " + N + " = No permutation");
    		}
    	}
    }

}
