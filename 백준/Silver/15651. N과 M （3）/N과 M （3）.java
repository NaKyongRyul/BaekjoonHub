import java.util.Scanner;
//완전 탐색(1)
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
    }

    static void rec_func(int k) {
        if(k == M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            for(int cand=1; cand<=N; cand++) {
                arr[k] = cand;
                rec_func(k+1);
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(sb.toString());
    }
}
