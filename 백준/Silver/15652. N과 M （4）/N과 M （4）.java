import java.util.Scanner;
//완전 탐색(3)
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M+1];
    }

    static void rec_func(int k) {
        if(k == M+1) {
            for(int i=1; i<=M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            int start = arr[k-1];
            if(start == 0) {
                start = 1;
            }
            for(int cand=start; cand<=N; cand++) {
                arr[k] = cand;
                rec_func(k+1);
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}
