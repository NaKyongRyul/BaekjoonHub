import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int time = sc.nextInt();

        int sum = min + time;

        if(sum < 60) {
            System.out.println(hour + " " + sum);
        }
        else {
            min = sum % 60;
            hour += sum / 60;

            if(hour < 24) {
                System.out.println(hour + " " + min);
            }
            else {
                hour %= 24;
                System.out.println(hour + " " + min);
            }
        }
    }
}