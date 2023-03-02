import java.util.Scanner;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i=0; i<arr.length; i++) {
           arr[i] = sc.nextInt();
        }

        for(int i=0; i<arr.length; i++) {
            sosu(arr[i]);
        }
        System.out.println(count);
    }

    //sosu(number) -> number 값이 소수인지 구하는 함수
    public static void sosu(int number) {
        if(number == 1) {
            return;
        }

        if(number == 2 || number == 3) {
            count++;
            return;
        }

        for(int i=2; i<=number/2; i++) {
            if(number % i == 0) {
                return;
            }
        }
        count++;
    }
}
