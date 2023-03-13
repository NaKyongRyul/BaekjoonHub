import java.util.Scanner;
//완전 탐색
//크기가 양수인 부분수열 -> 원소가 1개 이상인 부분수열
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, S;
    static int[] arr;
    static int count;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }
    }



    static void rec_func(int k, int value) {
        if(k == N+1) {
            if(value == S) {
                count++;
            }
        }
        else {
            rec_func(k+1, value+arr[k]);
            rec_func(k+1, value);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        if(S == 0) {
            count--;
        }
        System.out.println(count);
    }
}
