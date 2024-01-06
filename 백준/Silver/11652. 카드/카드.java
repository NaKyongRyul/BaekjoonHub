import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        long maxKey = 0;
        int maxValue = 0;
        for(Map.Entry<Long, Integer> entry : map.entrySet()) {
            long key = entry.getKey();
            int value = entry.getValue();

            if(value > maxValue || (value == maxValue && key < maxKey)) {
                maxKey = key;
                maxValue = value;
            }
        }
        sb.append(maxKey);
        System.out.println(sb);
    }
}