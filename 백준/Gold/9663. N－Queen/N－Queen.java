import java.util.Scanner;
//완전 탐색
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static int count;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
    }

    //
    static boolean attack(int r1, int c1, int r2, int c2) {
        if(c1 == c2) {
            return true;
        }
        else if(r1 - c1 == r2 - c2) {
            return true;
        }
        else if(r1 + c1 == r2 + c2) {
            return true;
        }
        return false;
    }

    static void rec_func(int row) {
        if(row == N+1) {
            count++;
        }
        else {
            for(int cand=1; cand<=N; cand++) {
                boolean possible = true;
                for(int i=1; i<=row-1; i++) {
                    if(attack(row, cand, i, arr[i])) {
                        possible = false;
                        break;
                    }
                }
                if(possible) {
                    arr[row] = cand;
                    rec_func(row+1);
                    arr[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(count);
    }
}
