import java.util.*;

public class Main {
    static int N, M;
    static String[] hear, see, ansArr;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // nextLine 사용 시, 이전에 next()나 nextInt() 함수 등을 사용한다면 한줄 추가
        hear = new String[N+1];
        see = new String[M+1];
        for(int i=1; i<=N; i++) {
            hear[i] = sc.nextLine();
        }
        for(int i=1; i<=M; i++) {
            see[i] = sc.nextLine();
        }
    }

    static boolean binary_search(String[] A, int L, int R, String X) {
        while(L <= R) {
            int mid = (L + R) / 2;
            if(X.compareTo(A[mid]) > 0) {
                L = mid + 1;
            } else if(X.compareTo(A[mid]) < 0) {
                R = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    static void pro() {
        int count = 0;
        Arrays.sort(see, 1, M+1);
        Arrays.sort(hear, 1, N+1);
        
        for(int i=1; i<=N; i++) {
            if(binary_search(see, 1, M, hear[i])) {
                count++;
            }
        }
        System.out.println(count);

        for(int i=1; i<=N; i++) {
            if(binary_search(see, 1, M, hear[i])) {
                System.out.println(hear[i]);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}



