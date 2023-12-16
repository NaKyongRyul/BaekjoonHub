import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dfs(0,0);
        list.sort(null);

        try {
            sb.append(list.get(N-1));
        } catch(Exception e) {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    static void dfs(long num, int index) {
        if(!list.contains(num)) {
            list.add(num);
        }

        if(index >= 10) return;

        dfs(num*10+arr[index], index+1);
        dfs(num, index+1);
    }

}
