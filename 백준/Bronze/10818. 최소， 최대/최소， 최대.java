import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : arr) {
            if(num < min) {
                min = num;
            }
            if(num > max) {
                max = num;
            }
        }

        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }
}

