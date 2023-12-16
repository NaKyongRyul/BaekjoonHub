import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String[] extension;
    static Map<String, Integer> map = new HashMap();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            extension = br.readLine().split("\\.");
            map.put(extension[1], map.getOrDefault(extension[1], 0)+1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            sb.append(key + " " + map.get(key) + "\n");
        }
        System.out.println(sb);
    }
}
