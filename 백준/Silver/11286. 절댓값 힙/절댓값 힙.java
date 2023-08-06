import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;
    static Queue<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new PriorityQueue<>((o1, o2) -> {
           int abs1 = Math.abs(o1);
           int abs2 = Math.abs(o2);

           //절대값 오름차순
           if(abs1 != abs2) {
               return abs1 - abs2;
           }
           //절대값이 같으면 그냥 값 오름차순
           else {
               return o1 - o2;
           }
        });

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(arr.isEmpty()) {
                    sb.append(0 + "\n");
                }
                else {
                    sb.append(arr.poll() + "\n");
                }
            }
            else {
                arr.add(input);
            }
        }
        System.out.println(sb);
    }
}