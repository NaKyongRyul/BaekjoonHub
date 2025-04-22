import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    static boolean isUsed;

    static void rec_func(int k) {
        if(k == M+1) {
            for(int i=1; i<=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i=1; i<=N; i++) {
                isUsed = false;
                for(int j=1; j<k; j++) {
                    if(i == selected[j]) {
                        isUsed = true;
                    }
                }
                if(!isUsed) {
                    selected[k] = i;
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];

        rec_func(1);
        System.out.println(sb);
    }
}
