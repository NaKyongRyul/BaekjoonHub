import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int test_cnt, n, degree, arr[][], temp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        test_cnt = Integer.parseInt(br.readLine());

        for(int a=0; a<test_cnt; a++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            degree = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            for(int x=0; x<n; x++) {
                st = new StringTokenizer(br.readLine());
                for(int y=0; y<n; y++) {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                }
            }
            if(degree > 0) {
                for(int b=0; b<Math.abs(degree/45); b++) {
                    plus_rule();
                }
            } else {
                for(int b=0; b<Math.abs(degree/45); b++) {
                    minus_rule();
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void plus_rule() {
        temp = new int[n][n];
        for(int i=0; i<n; i++) {
            temp[i][(n-1)/2] = arr[i][i];
            temp[i][n-i-1] = arr[i][(n-1)/2];
            temp[(n-1)/2][i] = arr[n-i-1][i];
            temp[i][i] = arr[(n-1)/2][i];
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(temp[i][j] == 0) {
                    temp[i][j] = arr[i][j];
                }
                arr[i][j] = temp[i][j];
            }
        }
    }

    static void minus_rule() {
        temp = new int[n][n];
        for(int i=0; i<n; i++) {
            temp[(n-1)/2][i] = arr[i][i];
            temp[i][i] = arr[i][(n-1)/2];
            temp[n-i-1][(n-1)/2] = arr[n-i-1][i];
            temp[n-i-1][i] = arr[(n-1)/2][i];
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(temp[i][j] == 0) {
                    temp[i][j] = arr[i][j];
                }
                arr[i][j] = temp[i][j];
            }
        }
    }
}