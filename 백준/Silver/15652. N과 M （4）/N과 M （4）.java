import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        rec_func(1,0);
        System.out.println(sb);
    }

    static void rec_func(int start, int x) {
        if(x == M) {
            for(int i=0; i<M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
        } else {
            for(int i=start; i<=N; i++) {
                selected[x] = i;
                rec_func(i,x+1);
            }
        }
    }
}