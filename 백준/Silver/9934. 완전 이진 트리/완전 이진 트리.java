import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] arr;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        arr = new int[(int)Math.pow(2, K)-1];
        list = new ArrayList[K];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++) {
            list[i] = new ArrayList<>();
        }

        dfs(0, arr.length - 1, 0);
        for(int i=0; i<K; i++) {
            for(int x : list[i]) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int end, int depth) {
        if(depth == K) return;
        int mid = (start+end)/2;
        list[depth].add(arr[mid]);
        dfs(start, mid-1, depth+1);
        dfs(mid+1, end, depth+1);
    }
}