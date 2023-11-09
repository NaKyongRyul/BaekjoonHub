import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int arr1_i = 0;
        int arr2_i = 0;

        while(arr1_i < N && arr2_i < M) {
            if(arr1[arr1_i] >= arr2[arr2_i]) {
                sb.append(arr2[arr2_i++] + " ");
            } else {
                sb.append(arr1[arr1_i++] + " ");
            }
        }

        if(arr1_i == N) {
            for(int i=arr2_i; i<M; i++) {
                sb.append(arr2[i] + " ");
            }
        }

        if(arr2_i == M) {
            for(int i=arr1_i; i<N; i++) {
                sb.append(arr1[i] + " ");
            }
        }
        System.out.println(sb);
    }
}