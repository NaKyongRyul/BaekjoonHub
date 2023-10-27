import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] baseball;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        baseball = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            baseball[i][0] = num;
            baseball[i][1] = strike;
            baseball[i][2] = ball;
        }

        for(int i=123; i<=987; i++) {
            int[] arr = new int[3];
            arr[0] = i/100;
            arr[1] = (i/10)%10;
            arr[2] = i%10;

            if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) continue;
            if(arr[1] == 0 || arr[2] == 0) continue;

            boolean isTrue = true;

            for(int j=0; j<N; j++) {
                int[] baseball_arr = new int[3];
                baseball_arr[0] = baseball[j][0]/100;
                baseball_arr[1] = (baseball[j][0]/10)%10;
                baseball_arr[2] = baseball[j][0]%10;

                int strike = 0;
                int ball = 0;

                for(int k=0; k<3; k++) {
                    if(arr[k] == baseball_arr[k]) strike++;
                    else if(arr[k] == baseball_arr[(k+1)%3] || arr[k] == baseball_arr[(k+2)%3]) ball++;
                }

                if(strike != baseball[j][1] || ball != baseball[j][2]) {
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) ans++;
        }
        sb.append(ans);
        System.out.println(sb);
    }
}