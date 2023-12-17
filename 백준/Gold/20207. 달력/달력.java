import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, startDay, endDay;
    static int[] cnt = new int[366];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            startDay = Integer.parseInt(st.nextToken());
            endDay = Integer.parseInt(st.nextToken());
            for(int j=startDay; j<=endDay; j++) {
                cnt[j]++;
            }
        }

        int width = 0;
        int maxHeight = 0;
        int sum = 0;

        for(int i=0; i<=365; i++) {
            if(cnt[i] == 0) {
                sum += width*maxHeight;
                width = 0;
                maxHeight = 0;
            } else {
                width++;
                maxHeight = Math.max(maxHeight, cnt[i]);
            }
        }
        sum += width*maxHeight;
        sb.append(sum);
        System.out.println(sb);
    }
}
