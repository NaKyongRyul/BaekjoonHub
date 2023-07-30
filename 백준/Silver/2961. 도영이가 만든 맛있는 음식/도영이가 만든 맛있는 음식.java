import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean visited[];
    static int[] arrS, arrB;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arrS = new int[N];//신맛 배열
        arrB = new int[N];//쓴맛 배열
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arrS[i] = Integer.parseInt(st.nextToken());
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        rec_fun(0);
        System.out.println(ans);
        System.out.println(sb);
    }

    static void rec_fun(int depth) {
        if(depth == N) {
            int sumS = 1, sumB = 0;
            for(int i=0; i<N; i++) {
                if(visited[i]) {
                    sumS *= arrS[i];
                    sumB += arrB[i];
                }
            }
            if(sumB != 0) {
                int curAns = Math.abs(sumS - sumB);
                ans = (ans < curAns) ? ans : curAns;
            }
            return;
        }
        //depth번째 재료 사용시
        visited[depth] = true;
        rec_fun(depth+1);

        //depth번째 재료 미사용시
        visited[depth] = false;
        rec_fun(depth+1);
    }
}