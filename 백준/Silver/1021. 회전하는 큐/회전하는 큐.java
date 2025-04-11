import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            int target_index = list.indexOf(arr[i]);
            int half_index;

            if(list.size() % 2 == 0) {
                half_index = list.size() / 2 - 1;
            } else {
                half_index = list.size() / 2;
            }

            if(target_index <= half_index) {
                for(int j=0; j<target_index; j++) {
                    int temp = list.pollFirst();
                    list.add(temp);
                    count++;
                }
            } else {
                for(int j=0; j<list.size()-target_index; j++) {
                    int temp = list.pollLast();
                    list.addFirst(temp);
                    count++;
                }
            }
            list.pollFirst();
        }
        sb.append(count);
        System.out.println(sb);
    }
}
