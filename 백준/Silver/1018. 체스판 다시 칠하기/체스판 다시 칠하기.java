import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int cnt;
    static String[] arr;

    public static int getSolution(int startRow, int startCol) {
        String[] orgArr = {"WBWBWBWB", "BWBWBWBW"};
        int whiteStartCnt = 0;
        for(int i=0; i<8; i++) {
            int row = startRow+i;
            for(int j=0; j<8; j++) {
                int col = startCol+j;
                if(arr[row].charAt(col) != orgArr[row%2].charAt(j)) {
                    whiteStartCnt++;
                }
            }
        }
        return Math.min(whiteStartCnt, 64-whiteStartCnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new String[row];

        for(int i=0; i<row; i++) {
            arr[i] = br.readLine();
        }

        cnt = Integer.MAX_VALUE;
        for(int i=0; i<=row-8; i++) {
            for(int j=0; j<=col-8; j++) {
                int curCnt = getSolution(i, j);
                if(cnt > curCnt) {
                    cnt = curCnt;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}