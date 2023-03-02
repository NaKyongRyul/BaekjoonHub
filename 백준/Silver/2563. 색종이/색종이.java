import java.util.Scanner;

//문제방향 다시 생각하기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[][] arr = new int[101][101];
        int count = 0;

        for(int a=0; a<num; a++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int i=x; i<x+10; i++) {
                for(int j=y; j<y+10; j++) {
                    if(arr[i][j] == 1) {
                        continue;
                    }
                    arr[i][j] = 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
