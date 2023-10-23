import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int cnt, cheolsu[][], ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        cheolsu = new int[5][5];

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                cheolsu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Loop:
        for(int a=0; a<5; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<5; b++) {
                ans++;
                int n = Integer.parseInt(st.nextToken());

                for(int i=0; i<5; i++) {
                    for(int j=0; j<5; j++) {
                        if(n == cheolsu[i][j]) cheolsu[i][j] = 0;
                    }
                }
                horizontal();
                vertical();
                right_cross();
                left_cross();
                if(cnt >= 3) {
                    sb.append(ans);
                    break Loop;
                }
                cnt = 0;
            }
        }
        System.out.println(sb);
    }

    static void horizontal() {
        for(int i=0; i<5; i++) {
            int cur_cnt = 0;
            for(int j=0; j<5; j++) {
                if(cheolsu[i][j] == 0) cur_cnt++;
                else break;
            }
            if(cur_cnt == 5) cnt++;
        }
    }

    static void vertical() {
        for(int i=0; i<5; i++) {
            int cur_cnt = 0;
            for(int j=0; j<5; j++) {
                if(cheolsu[j][i] == 0) cur_cnt++;
                else break;
            }
            if(cur_cnt == 5) cnt++;
        }
    }

    static void right_cross() {
        int cur_cnt = 0;
        for(int i=0; i<5; i++) {
            if(cheolsu[i][i] == 0) cur_cnt++;
            else break;

            if(cur_cnt == 5) cnt++;
        }
    }

    static void left_cross() {
        int cur_cnt = 0;
        for(int i=0; i<5; i++) {
            if(cheolsu[i][4-i] == 0) cur_cnt++;
            else break;

            if(cur_cnt == 5) cnt++;
        }
    }
}