import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] a;
    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new ArrayList[N+1];
        for(int color=1; color<=N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for(int i=1; i<=N; i++) {
            int pos, color;
            pos = sc.nextInt();
            color = sc.nextInt();
            a[color].add(pos);
        }
    }

    static int toLeft(int color, int index) {
        if(index == 0) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(index) - a[color].get(index - 1);
    }

    static int toRight(int color, int index) {
        if(index + 1 == a[color].size()) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(index + 1) - a[color].get(index);
    }


    static void pro() {
        for(int color = 1; color<=N; color++) {
            Collections.sort(a[color]);
        }

        int ans = 0;
        for(int color = 1; color<=N; color++) {
            for(int i=0; i<a[color].size(); i++) {
                int left = toLeft(color, i);
                int right = toRight(color, i);
                ans += Math.min(left, right);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
