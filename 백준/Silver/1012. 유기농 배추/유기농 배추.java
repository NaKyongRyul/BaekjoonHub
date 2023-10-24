import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int T, M, N, K, cnt;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            isVisit = new boolean[M][N];
            cnt = 0;

            for(int k=0; k<K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] == 1 && !isVisit[i][j]) bfs(i,j);
                }
            }
            sb.append(cnt);
            System.out.println(sb);
        }
    }

    static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b));
        isVisit[a][b] = true;
        cnt++;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i=0; i<4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if(x<0 || y<0 || x>=M || y>=N) continue;
                if(arr[x][y] == 1 && !isVisit[x][y]) {
                    queue.add(new Node(x,y));
                    isVisit[x][y] = true;
                }
            }
        }
    }
}