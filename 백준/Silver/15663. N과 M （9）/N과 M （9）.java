import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr_N;
    static int[] arr_M;
    static boolean[] isVisit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr_N = new int[N];
        arr_M = new int[M];
        isVisit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr_N[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_N);
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int m : arr_M) {
                sb.append(m + " ");
            }
            sb.append("\n");
            return;
        }

        int beforeNum = 0;
        for(int i=0; i<N; i++) {
            if(isVisit[i]) continue;
            if(beforeNum != arr_N[i]) {
                isVisit[i] = true;
                arr_M[depth] = arr_N[i];
                beforeNum = arr_N[i];
                dfs(depth+1);
                isVisit[i] = false;
            }
        }
    }
}
