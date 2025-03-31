import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();

            int frontParentheses = 0;
            int beforeParentheses = 0;
            boolean isTrue = true;

            for(int j=0; j<s.length(); j++) {
                if(arr[j] == '(') frontParentheses++;
                if(arr[j] == ')') beforeParentheses++;
                if(frontParentheses < beforeParentheses) {
                    isTrue = false;
                    break;
                }
            }
            if(isTrue && frontParentheses == beforeParentheses) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
