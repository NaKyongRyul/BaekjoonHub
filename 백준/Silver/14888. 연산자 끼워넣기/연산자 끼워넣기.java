import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] operator;
    static int max, min;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        arr = new int[N];
        operator = new int[4];
        selected = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        rec_func(0);
        sb.append(max + "\n" + min);
        System.out.println(sb);
    }

    //dfs? -> ㅇㅇ
    static void rec_func(int x) {
        if(x == N-1) {
            int val = calculator();
            max = Math.max(max, val);
            min = Math.min(min, val);
        } else {
            for(int i=0; i<4; i++) {
                if(operator[i] > 0) {
                    selected[x] = i;
                    operator[i]--;
                    rec_func(x+1);
                    operator[i]++;
                }
            }
        }
    }

    static int calculator() {
        int val = arr[0];
        for(int i=0; i<N-1; i++) {
            if(selected[i] == 0) {
                val = val + arr[i+1];
            } else if(selected[i] == 1) {
                val = val - arr[i+1];
            } else if(selected[i] == 2) {
                val = val * arr[i+1];
            } else if(selected[i] == 3) {
                val = val / arr[i+1];
            }
        }
        return val;
    }
}