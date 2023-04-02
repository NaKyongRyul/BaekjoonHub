import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
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
        int sumNear_0 = Integer.MAX_VALUE;
        int n1 = 0, n2 = 0;
        for(int i=1; i<=N-1; i++) {
            int lower = lower_bound(A, i+1, N, -A[i]);
            if(i+1 <= lower-1 && lower-1 <= N && Math.abs(A[i]+A[lower-1]) < sumNear_0) {
                sumNear_0 = Math.abs(A[i] + A[lower-1]);
                n1 = A[i];
                n2 = A[lower-1];
            }
            if(i+1 <= lower && lower <= N && Math.abs(A[i]+A[lower]) < sumNear_0) {
                sumNear_0 = Math.abs(A[i] + A[lower]);
                n1 = A[i];
                n2 = A[lower];
            }
        }
        sb.append(n1).append(' ').append(n2);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}