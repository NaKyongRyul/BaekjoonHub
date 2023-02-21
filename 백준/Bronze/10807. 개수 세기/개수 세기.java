import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] arr = new int[count];
        int equalCount = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < -100 || arr[i] > 100) {
                break;
            }
            arr[i] = sc.nextInt();
        }

        int findNum = sc.nextInt();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == findNum) {
                equalCount++;
            }
        }
        System.out.println(equalCount);
    }
}