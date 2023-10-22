import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int computer_cnt, line, ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        computer_cnt = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        arr = new int[computer_cnt+1][computer_cnt+1];

        for(int i=0; i<line; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        sb.append(bfs());
        System.out.println(sb);
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[computer_cnt+1];
        queue.offer(1);
        isVisit[1] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int i=1; i<computer_cnt+1; i++) {
                if(arr[node][i] == 1 && isVisit[i] == false) {
                    queue.offer(i);
                    isVisit[i] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}