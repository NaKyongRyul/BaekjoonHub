import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int testCase, n, m, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> queue = new LinkedList<>();

            for(int j=0; j<n; j++) {
                queue.offer(new int[] {
                        j, Integer.parseInt(st.nextToken())
                });
            }

            count = 0;

            while(!queue.isEmpty()) {
                int[] firstNum = queue.poll();
                boolean isMax = true;

                for(int j=0; j<queue.size(); j++) {
                    if(firstNum[1] < queue.get(j)[1]) {
                        queue.offer(firstNum);
                        for(int z=0; z<j; z++) {
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(isMax == false) continue;

                count++;
                if(firstNum[0] == m) break;
            }
            sb.append(count +"\n");
        }
        System.out.println(sb);
    }
}