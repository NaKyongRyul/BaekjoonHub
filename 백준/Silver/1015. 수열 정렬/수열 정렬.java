import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {
        // num - A[idx] 값
        // idx - A 배열의 idx 위치
        public int num, idx;

        public int compareTo(Elem other) {
            if(num != other.num) {
                return num - other.num;
            }
            return idx - other.idx;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = sc.nextInt();
            B[i].idx = i;
        }
    }

    static void pro() {
        Arrays.sort(B);

//        System.out.println("B[0].num = " + B[0].num);
//        System.out.println("B[1].num = " + B[1].num);
//        System.out.println("B[2].num = " + B[2].num);
//        System.out.println("B[3].num = " + B[3].num);
//
//        System.out.println();
//
//        System.out.println("B[0].idx = " + B[0].idx);
//        System.out.println("B[1].idx = " + B[1].idx);
//        System.out.println("B[2].idx = " + B[2].idx);
//        System.out.println("B[3].idx = " + B[3].idx);

        for(int i=0; i<N; i++) {
            P[B[i].idx] = i;
        }

        for(int i=0; i<N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
