import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] arr_N;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr_N = new String[N+1];

        for(int i=1; i<N+1; i++) {
            arr_N[i] = br.readLine();
            map.put(arr_N[i], i);
        }

        for(int i=1; i<M+1; i++) {
            String s = br.readLine();
            if(map.containsKey(s)) sb.append(map.get(s) + "\n");
            else sb.append(arr_N[Integer.parseInt(s)] + "\n");
        }
        System.out.println(sb);
    }
}