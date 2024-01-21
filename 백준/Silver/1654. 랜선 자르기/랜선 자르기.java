import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];

        long max = 0;

        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        max++;
        long result = findMaxLength(arr,n,max);
        sb.append(result);
        System.out.println(sb);
    }

    public static long findMaxLength(int[] arr, int n, long max) {
        long min = 0;
        long mid;

        while (min < max) {
            mid = (max + min) / 2;

            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }
}