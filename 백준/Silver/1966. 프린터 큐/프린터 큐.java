import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(j, priority));
                priorityQueue.offer(priority);
            }

            int printOrder = 0;

            while(!queue.isEmpty()) {
                Document currentDocument = queue.poll();
                if(currentDocument.priority == priorityQueue.peek()) {
                    printOrder++;
                    priorityQueue.poll();

                    if(currentDocument.index == M) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                } else {
                  queue.offer(currentDocument);
                }
            }
        }
        System.out.println(sb);
    }
}
