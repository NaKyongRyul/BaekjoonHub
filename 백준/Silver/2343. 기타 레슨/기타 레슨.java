import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(start < arr[i]) {
                start = arr[i];
            }
            end += arr[i];
        }

        while(start <= end) {
            int middle = (start+end)/2;
            int sum = 0;
            int count = 1;

            for(int i=0; i<N; i++) {
                if(sum + arr[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if(count > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        sb.append(start);
        System.out.println(sb);
    }
}