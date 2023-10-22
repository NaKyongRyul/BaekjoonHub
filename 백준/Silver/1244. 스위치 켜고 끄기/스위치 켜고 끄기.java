import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int switch_cnt, stu_cnt, gender, switch_num;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        switch_cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[switch_cnt+1];

        for(int i=1; i<switch_cnt+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stu_cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<stu_cnt; i++) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            switch_num = Integer.parseInt(st.nextToken());

            //스위치 처리
            if(gender == 1) man_switch();
            else if(gender == 2) woman_switch();
        }

        for(int i=1; i<switch_cnt+1; i++) {
            sb.append(arr[i] + " ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    static void man_switch() {
        for(int i=1; i<switch_cnt+1; i++) {
            if(i % switch_num == 0) {
                if(arr[i] == 0) arr[i] = 1;
                else if(arr[i] == 1) arr[i] = 0;
            }
        }
    }

    static void woman_switch() {
        for(int i=1; i<switch_cnt/2; i++) {
            if(switch_num-i > 0 && switch_num+i <= switch_cnt && arr[switch_num-i] == arr[switch_num+i]) {
                if(arr[switch_num-i] == 0) {
                    arr[switch_num-i] = 1;
                    arr[switch_num+i] = 1;
                }
                else if(arr[switch_num-i] == 1) {
                    arr[switch_num-i] = 0;
                    arr[switch_num+i] = 0;
                }
            }
            else break;
        }
        if(arr[switch_num] == 0) arr[switch_num] = 1;
        else arr[switch_num] = 0;
    }
}