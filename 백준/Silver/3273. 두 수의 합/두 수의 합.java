import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int result = 0;
        for(int i=0; i<N; i++) {
            int find_num = X - arr[i];
            result += binary_search(arr, 0, N-1, find_num);
        }
        sb.append(result/2);
        System.out.println(sb);
    }

    static int binary_search(int[] arr, int L, int R, int X) {
        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] > X) {
                R = mid - 1;
            } else if(arr[mid] < X) {
                L = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

}
