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
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        dist = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=M; j++) {
                arr[i][j] = (int)(s.charAt(j-1)-'0');
            }
        }

        bfs(1,1);
        sb.append(dist[N][M]);
        System.out.println(sb);
    }

    static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisit = new boolean[N+1][M+1];
        queue.add(new Node(a, b));
        isVisit[a][b] = true;
        dist[a][b] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i=0; i<4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if(x<1 || y<1 || x>=N+1 || y>=M+1) continue;
                if(arr[x][y] == 1 && !isVisit[x][y]) {
                    queue.add(new Node(x,y));
                    isVisit[x][y] = true;
                    dist[x][y] = dist[node.x][node.y] + 1;
                }
            }
        }
    }
}