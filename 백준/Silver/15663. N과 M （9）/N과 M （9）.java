import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static boolean[] isVisit;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        isVisit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        rec_func(0);
        System.out.println(sb);
    }

    static void rec_func(int x) {
        if(x == M) {
            for(int i=0; i<M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
        } else {
            int prev = 0;
            for(int i=0; i<N; i++) {
                if(isVisit[i] || prev == arr[i]) continue;
                isVisit[i] = true;
                selected[x] = arr[i];
                prev = arr[i];
                rec_func(x+1);
                isVisit[i] = false;
            }
        }
    }
}