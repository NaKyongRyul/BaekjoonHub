import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int threePack = 0;
        int fivePack = 0;
        int remain = 0;

        if(num % 5 == 0) {
            fivePack = num / 5;
        } else {
            for(int i=num/5; i>=0; i--) {
                remain = num - 5 * i;
                if(remain % 3 == 0) {
                    fivePack = i;
                    threePack = remain / 3;
                    break;
                }
            }
        }
        if(fivePack + threePack == 0) {
            System.out.println(-1);
        } else {
            System.out.println(fivePack + threePack);
        }
    }
}
