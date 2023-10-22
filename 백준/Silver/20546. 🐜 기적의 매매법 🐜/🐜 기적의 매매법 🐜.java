import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int money, arr[], BNP_cnt, TIMING_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        money = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[14];

        for(int i=0; i<14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(BNP(money) > TIMING(money)) sb.append("BNP");
        else if(BNP(money) < TIMING(money)) sb.append("TIMING");
        else sb.append("SAMESAME");
        System.out.println(sb);
    }

    static int BNP(int cur_money) {
        int cnt;
        for(int i=0; i<14; i++) {
            if(cur_money >= arr[i]) {
                cnt = cur_money / arr[i];//해당날짜에 산 주식 개수
                BNP_cnt += cnt;//전체 주식 개수
                cur_money %= arr[i];//현재 잔액
            }
        }
        return cur_money + BNP_cnt * arr[13];
    }

    static int TIMING(int cur_money) {
        int cnt;
        int buy_cnt = 0;
        int sell_cnt = 0;

        for(int i=0; i<13; i++) {
            if(arr[i] > arr[i+1]) {
                buy_cnt += 1;
                sell_cnt = 0;
            } else if(arr[i] == arr[i+1]) {
                buy_cnt = 0;
                sell_cnt = 0;
            } else {
                sell_cnt += 1;
                buy_cnt = 0;
            }

            if(buy_cnt >= 3 && cur_money >= arr[i+1]) {
                TIMING_cnt += cur_money / arr[i+1];//전체 주식 개수
                cur_money %= arr[i+1];//현재 잔액
            }

            if(sell_cnt >= 3 && TIMING_cnt > 0) {
                cur_money += TIMING_cnt * arr[i+1];
                TIMING_cnt = 0;
            }
        }
        return cur_money + TIMING_cnt * arr[13];
    }

}