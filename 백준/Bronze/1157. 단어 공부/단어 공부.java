import java.util.Scanner;

//다시 해보기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[26];
        String str = sc.next();
        str = str.toUpperCase();
        int max = 0;

        for(int i=0; i<str.length(); i++) {
            arr[str.charAt(i)-'A']++;
        }

        char c = '?';

        for(int i=0; i<26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                c = (char)(i+'A');
            }
            else if(arr[i] == max) {
                c = '?';
            }
        }
        System.out.println(c);
    }
}
