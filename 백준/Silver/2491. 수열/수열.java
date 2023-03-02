import java.util.Scanner;
//다시 해보기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        int bigCount = 1;
        int smallCount = 1;
        int max = 1;

        for(int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<num-1; i++) {
            if(arr[i] <= arr[i+1]) {
                bigCount++;
            }
            else {
                bigCount = 1;
            }
            max = Math.max(max, bigCount);
        }

        for(int i=0; i<num-1; i++) {
            if(arr[i] >= arr[i+1]) {
                smallCount++;
            }
            else {
                smallCount = 1;
            }
            max = Math.max(max, smallCount);
        }
        System.out.println(max);
    }
}
