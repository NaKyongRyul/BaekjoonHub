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
    static int T, N;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,-2,-1,1,2};
    static boolean[][] isVisit;
    static int[][] dist;
    static int goal_x, goal_y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int cur_x = Integer.parseInt(st.nextToken());
            int cur_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goal_x = Integer.parseInt(st.nextToken());
            goal_y = Integer.parseInt(st.nextToken());

            isVisit = new boolean[N][N];
            dist = new int[N][N];

            bfs(cur_x, cur_y);
            sb.append(dist[goal_x][goal_y] + "\n");
        }
        System.out.println(sb);
    }

    static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a,b));
        isVisit[a][b] = true;
        dist[a][b] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i=0; i<8; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if(x<0 || y<0 || x>=N || y>=N) continue;
                if(!isVisit[x][y]) {
                    queue.add(new Node(x,y));
                    isVisit[x][y] = true;
                    dist[x][y] = dist[node.x][node.y] + 1; // 수정된 부분
                }
            }
        }
    }
}
