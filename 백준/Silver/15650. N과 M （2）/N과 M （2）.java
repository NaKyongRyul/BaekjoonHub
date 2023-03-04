import java.util.Scanner;
//완전 탐색(4)
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
            for(int cand=arr[k-1]+1; cand<=N; cand++) {
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
