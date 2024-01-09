import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static String[] arr_hear, arr_see, arr_ans;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        if(N > M) {
//            arr_ans = new String[M];
//        } else {
//            arr_ans = new String[N];
//        }
        arr_hear = new String[N];
        arr_see = new String[M];
        list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr_hear[i] = br.readLine();
        }

        for(int i=0; i<M; i++) {
            arr_see[i] = br.readLine();
        }

        Arrays.sort(arr_see);

        int ans = 0;
        for(int i=0; i<N; i++) {
            ans += binary_search(arr_see, 0, M-1, arr_hear[i]);
        }

        Collections.sort(list);

        System.out.println(ans);
        for(String str : list) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }

    static int binary_search(String[] see, int L, int R, String X) {
        while(L <= R) {
            int mid = (L + R) / 2;
            // X 가 더 크다
            if(see[mid].compareTo(X) < 0) {
                L = mid + 1;
            } else if(see[mid].compareTo(X) > 0) {
                R = mid - 1;
            } else {
                list.add(X);
                return 1;
            }
        }
        return 0;
    }

}
