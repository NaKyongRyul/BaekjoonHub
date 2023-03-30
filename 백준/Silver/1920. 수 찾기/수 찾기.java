import java.util.*;

public class Main {
    static int N, M;
    static int[] A, B;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = sc.nextInt();
        }
        M = sc.nextInt();
        B = new int[M+1];
        for(int i=1; i<=M; i++) {
            B[i] = sc.nextInt();
        }
    }

    static int binary_search(int[] A, int L, int R, int X) {
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] < X) {
                L = mid + 1;
            } else if(A[mid] > X){
                R = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    static void pro() {
        Arrays.sort(A, 1, N+1);

        for(int i=1; i<=M; i++) {
            System.out.println(binary_search(A, 1, N, B[i]));
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
