import java.util.*;

public class Main {
    static int N, M;
    static int[] A, B;
    static StringBuilder sb = new StringBuilder();
    
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

    static int lower_bound(int[] A, int L, int R, int X) {
        int ans = R+1;
        while(L<=R) {
            int mid = (L+R)/2;
            if(A[mid] >= X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static int upper_bound(int[] A, int L, int R, int X) {
        int ans = R+1;
        while(L<=R) {
            int mid = (L+R)/2;
            if(A[mid] > X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static void pro() {
        Arrays.sort(A, 1, N+1);
        for(int i=1; i<=M; i++) {
            int lower = lower_bound(A, 1, N, B[i]);
            int upper = upper_bound(A, 1, N, B[i]);
            sb.append(upper - lower).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}