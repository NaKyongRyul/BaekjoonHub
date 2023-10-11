import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        int num = 666;
        int cnt = 1;
        
        while(cnt != input) {
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
        sb.append(num);
        System.out.println(sb);
    }
}