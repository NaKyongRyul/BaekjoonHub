import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[] arr;
    static boolean[] isVisit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        isVisit = new boolean[N];

        rec_func(0);
        sb.append(ans);
        System.out.println(sb);
    }

    static void rec_func(int depth) {
        if(depth == N) {
            ans++;
        } else {
            for(int i=0; i<N; i++) {
                boolean isValid = true;
                for(int j=0; j<depth; j++) {
                    if(arr[j] == i || depth + i == j + arr[j] || depth - i == j - arr[j]) {
                        isValid = false;
                        break;
                    }
                }
                if(!isValid) continue;

                arr[depth] = i;
                rec_func(depth+1);
            }
        }
    }
}