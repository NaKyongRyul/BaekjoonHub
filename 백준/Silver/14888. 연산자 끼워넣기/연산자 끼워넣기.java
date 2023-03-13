import java.util.Scanner;
//완전 탐색
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, max, min;
    static int[] nums, operators, orders;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //전체 숫자가 저장된 배열
        nums = new int[N+1];
        operators = new int[5];
        //연산자가 저장될 위치
        orders = new int[N];
        for(int i=1; i<=N; i++) {
            nums[i] = sc.nextInt();
        }
        for(int i=1; i<=4; i++) {
            operators[i] = sc.nextInt();
        }
        //무조건 더 큰값이 되기 위해 가장 작은값으로 설정
        max=Integer.MIN_VALUE;
        //무조건 더 작은값이 되기 위해 가장 큰값으로 설정
        min=Integer.MAX_VALUE;
    }

    static int calculator() {
        int value = nums[1];
        for(int i=1; i<=N-1; i++) {
            if(orders[i] == 1) {
                value += nums[i+1];
            }
            if(orders[i] == 2) {
                value -= nums[i+1];
            }
            if(orders[i] == 3) {
                value *= nums[i+1];
            }
            if(orders[i] == 4) {
                value /= nums[i+1];
            }
        }
        return value;
    }


    static void rec_func(int k) {
        if(k == N) {
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        else {
            for(int cand=1; cand<=4; cand++) {
                if(operators[cand] >= 1) {
                    operators[cand]--;
                    orders[k] = cand;
                    rec_func(k+1);
                    operators[cand]++;
                    orders[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}
