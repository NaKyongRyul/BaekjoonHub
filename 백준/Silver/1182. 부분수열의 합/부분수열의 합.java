import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if(M == 0) ans--;
        rec_func(0, 0);
        sb.append(ans);
        System.out.println(sb);
    }

    static void rec_func(int x, int sum) {
        if(x == N) {
            if(M == sum) ans++;
        } else {
            rec_func(x+1, sum+nums[x]);
            rec_func(x+1, sum);
        }
    }
}