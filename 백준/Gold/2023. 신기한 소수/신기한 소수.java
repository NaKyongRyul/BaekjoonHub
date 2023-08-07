import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb);
    }

    private static void dfs(int num, int seq) {
        if(seq == N) {
            if(isPrime(num)) {
                sb.append(num + "\n");
            }
        }

        for(int i=1; i<10; i++) {
            if(i % 2 == 0) continue;
            if(isPrime(num*10+i)) {
                dfs(num*10+i, seq+1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}