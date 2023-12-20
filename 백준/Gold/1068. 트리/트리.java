import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, deleteNode, cnt, root;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        child = new ArrayList[N];
        leaf = new int[N];

        for(int i=0; i<N; i++) {
            child[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int par = Integer.parseInt(st.nextToken());
            if(par == -1) {
                root = i;
                continue;
            }
            child[par].add(i);
        }
        deleteNode = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            if(child[i].contains(deleteNode)) {
                child[i].remove(child[i].indexOf(deleteNode));
            }
        }
        if(root != deleteNode) dfs(root);
        sb.append(leaf[root]);
        System.out.println(sb);
    }

    static void dfs(int x) {
        if(child[x].isEmpty()) {
            leaf[x] = 1;
        }

        for(int y : child[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }

}