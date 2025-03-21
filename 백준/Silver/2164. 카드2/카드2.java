import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        int temp = 0;

        while(queue.size() > 1) {
            queue.poll();
            temp = queue.poll();
            queue.add(temp);
        }

        sb.append(queue.poll());
        System.out.println(sb);
    }
}
