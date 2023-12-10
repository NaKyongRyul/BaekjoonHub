import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr, word;
    static boolean[] isVisit;
    static int cnt_moum;
    static int cnt_jaum;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        word = new char[L];
        isVisit = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int idx, int depth) {
        if(depth == L) {
            if(isValid()) {
                sb.append(word);
                sb.append("\n");
            }
            return;
        }

        for(int i=idx; i<C; i++) {
            if(!isVisit[i]) {
                word[depth] = arr[i];
                isVisit[i] = true;
                dfs(i+1, depth+1);
                isVisit[i] = false;
            }
        }
    }

    static boolean isValid() {
        cnt_moum = 0;
        cnt_jaum = 0;

        for(int i=0; i<L; i++) {
            if(word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') cnt_moum++;
            else cnt_jaum++;
        }

        if(cnt_jaum >= 2 && cnt_moum >= 1) return true;
        else return false;
    }
}
