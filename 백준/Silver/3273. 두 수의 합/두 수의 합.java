import java.util.*;

public class Main {
    static int N, X;
    static int[] A;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = sc.nextInt();
        }
        X = sc.nextInt();
    }

    static boolean binary_search(int[] A, int L, int R, int X) {
        while(L<=R) {
            int mid = (L+R)/2;
            if(A[mid] == X) {
                return true;
            } else if(A[mid] > X) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }

    static void pro() {
        int count = 0;
        Arrays.sort(A, 1, N+1);
        for(int i=1; i<=N-1; i++) {
            if(binary_search(A, i+1, N, X-A[i])) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}