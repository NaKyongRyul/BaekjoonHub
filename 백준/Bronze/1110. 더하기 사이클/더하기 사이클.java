import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        int sum = 0;
        int newI = 0;
        int count = 0;

        if(i >= 10) {
            newI = i;
            do {
                int i1 = newI / 10; //십의자리 - 1
                int i2 = newI % 10; //일의자리 - 0
//                System.out.println(i1 + " + " + i2 + " = " + (i1+i2));

                sum = (i1 + i2) % 10; //1
                newI = i2 * 10 + sum; //1

//                System.out.println("새로운 수는 " + newI + "이다.");

                count++;
            } while(newI != i);
        }
        else {
            i *= 10;
            newI = i;
            do {
                int i1 = newI / 10; //십의자리 - 1
                int i2 = newI % 10; //일의자리 - 0
//                System.out.println(i1 + " + " + i2 + " = " + (i1+i2));

                sum = (i1 + i2) % 10; //1
                newI = i2 * 10 + sum; //1

//                System.out.println("새로운 수는 " + newI + "이다.");

                count++;
            } while(newI != i);
        }
        System.out.println(count);
    }
}