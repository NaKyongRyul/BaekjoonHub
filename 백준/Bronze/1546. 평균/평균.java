import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subCnt = sc.nextInt();
        double[] arr = new double[subCnt];
        double max = 0;
        double sum = 0;
        double avg = 0;


        for (int i=0; i<subCnt; i++) {
            arr[i] = sc.nextInt();
        }

        //최대값 구하기
        for(int i=0; i<subCnt; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        //점수 바꾸기
        for(int i=0; i<subCnt; i++) {
            arr[i] = arr[i] / max * 100;
        }

        for(int i=0; i<subCnt; i++) {
            sum += arr[i];
        }

        avg = sum / subCnt;
        System.out.println(avg);
    }
}