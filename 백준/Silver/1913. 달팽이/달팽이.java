import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, find_num, arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        find_num = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int x = 0, y = 0;
        int num = N*N;
        int length = N;
        int a = 0;

        int ans_x = 0;
        int ans_y = 0;

        while(num > 0) {
            //arr[0][0] ~ arr[4][0]
            x = a;
            for(int i=y; i<length; i++) {
                arr[i][x] = num--;
                if(find_num == num+1) {
                    ans_x = i+1;
                    ans_y = x+1;
                }
            }

            //arr[4][1] ~ arr[4][4]
            y = length-1;
            for(int i=x+1; i<length; i++) {
                arr[y][i] = num--;
                if(find_num == num+1) {
                    ans_x = y+1;
                    ans_y = i+1;
                }
            }

            //arr[3][4] ~ arr[0][4]
            x = length-1;
            for(int i=y-1; i>=a; i--) {
                arr[i][x] = num--;
                if(find_num == num+1) {
                    ans_x = i+1;
                    ans_y = x+1;
                }
            }

            //arr[0][3] ~ arr[0][1]
            y = a;
            for(int i=x-1; i>a; i--) {
                arr[y][i] = num--;
                if(find_num == num+1) {
                    ans_x = y+1;
                    ans_y = i+1;
                }
            }

            length--;
            a++;
            y = a;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(ans_x + " " + ans_y);
        System.out.println(sb);
    }
}