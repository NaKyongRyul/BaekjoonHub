import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String num = br.readLine();
            boolean isTrue = true;

            if(num.equals("0")) break;

            for(int i=0; i<num.length()/2; i++) {
                if(num.charAt(i) != num.charAt(num.length()-(i+1))) {
                    isTrue = false;
                    break;
                }
            }

            if(isTrue) {
                sb.append("yes" + "\n");
            } else {
                sb.append("no" + "\n");
            }
        }
        System.out.println(sb);
    }
}