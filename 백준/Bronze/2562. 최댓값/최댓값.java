import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int max = Integer.MIN_VALUE;
        int num = 0;

        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
                num = i+1;
            }
        }
        sb.append(max).append("\n").append(num);
        System.out.println(sb);
    }

}
