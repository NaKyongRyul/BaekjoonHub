import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] dy = {1,1,1,0,0,-1,-1,-1};


    static class Node {
        int x,y,count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    ans = Math.max(ans, bfs(i,j));
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        boolean[][] isVisit = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node (x,y,0));
        isVisit[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i=0; i<8; i++) {
                int move_x = node.x + dx[i];
                int move_y = node.y + dy[i];
                int count = node.count;

                if(move_x < 0 || move_y < 0 || move_x >= N || move_y >= M) continue;
                if(isVisit[move_x][move_y]) continue;
                if(arr[move_x][move_y] == 1) return count+1;
                queue.offer(new Node(move_x, move_y, count+1));
                isVisit[move_x][move_y] = true;
            }
        }
        return 0;
    }

}