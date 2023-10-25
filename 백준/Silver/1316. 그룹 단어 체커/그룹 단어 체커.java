import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            arr = new char[s.length()];
            boolean isGroupWord = true;
            int cur_cnt = 0;

            for(int j=0; j<s.length(); j++) {
                arr[j] = s.charAt(j);
            }

            Loop:
            for(int j=0; j<s.length()-1; j++) {
                if(arr[j] == arr[j+1]) {
                    cur_cnt++;
                    continue;
                }
                for(int k=0; k<j-cur_cnt; k++) {
                    if(arr[k] == arr[j+1]) {
                        isGroupWord = false;
                        break Loop;
                    }
                }
                cur_cnt = 0;
            }
            if(isGroupWord) cnt++;
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}