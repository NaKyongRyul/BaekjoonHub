import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] a;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new String[N + 1];
        for(int i=1; i<=N; i++) {
            a[i] = sc.next().split("\\.")[1];
        }
    }

    static void pro() {
        Arrays.sort(a, 1, N+1);

        for(int i=1; i<=N;) {
            int count = 1;
            int j = i + 1;
            for(;j<=N; j++) {
                if(a[j].compareTo(a[i]) == 0) {
                    count++;
                }
                else {
                    break;
                }
            }
            sb.append(a[i]).append(" ").append(count).append('\n');
            i=j;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
