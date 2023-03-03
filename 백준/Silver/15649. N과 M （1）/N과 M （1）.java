import java.util.Scanner;
//완전 탐색(2)
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr, used;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        used = new int[N+1];
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
                if(used[cand] == 1) {
                    continue;
                }
                arr[k] = cand;
                used[cand] = 1;
                rec_func(k+1);
                used[cand] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(sb.toString());
    }
}
