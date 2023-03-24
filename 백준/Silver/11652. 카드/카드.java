import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] a;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new long[N + 1];
        for(int i=1; i<=N; i++) {
            a[i] = sc.nextLong();
        }
    }

    static void pro() {
        Arrays.sort(a, 1, N+1);

        // curCnt: 현재 숫자 등장 횟수, modeCnt: 최빈값 등장 횟수, mode: 최빈값
        int curCnt = 1;
        int modeCnt = 1;
        long mode = a[1];

        for(int i=2; i<=N; i++) {
            if(a[i] == a[i-1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if(modeCnt < curCnt) {
                modeCnt = curCnt;
                mode = a[i];
            }
        }
        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
