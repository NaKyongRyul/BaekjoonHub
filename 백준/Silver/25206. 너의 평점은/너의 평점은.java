import java.util.Scanner;

//배열에서 값 같을 때 "==" 대신 equals() 사용하기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[20][3];

        for(int i=0; i<20; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = sc.next();
            }
        }

        double grade = 0;

        for(int i=0; i<20; i++) {
            if(arr[i][2].equals("A+")) {
                arr[i][2] = "4.5";
            }
            else if(arr[i][2].equals("A0")) {
                arr[i][2] = "4.0";
            }
            else if(arr[i][2].equals("B+")) {
                arr[i][2] = "3.5";
            }
            else if(arr[i][2].equals("B0")) {
                arr[i][2] = "3.0";
            }
            else if(arr[i][2].equals("C+")) {
                arr[i][2] = "2.5";
            }
            else if(arr[i][2].equals("C0")) {
                arr[i][2] = "2.0";
            }
            else if(arr[i][2].equals("D+")) {
                arr[i][2] = "1.5";
            }
            else if(arr[i][2].equals("D0")) {
                arr[i][2] = "1.0";
            }
            else if(arr[i][2].equals("F")) {
                arr[i][2] = "0.0";
            }
            else if(arr[i][2].equals("P")) {
                arr[i][1] = "0.0";
                arr[i][2] = "0.0";
            }
        }

        //학점 구하기
        double hakjum = 0;
        double hakjumSum = 0;
        double allSum = 0;

        for(int i=0; i<20; i++) {
            hakjum = Double.parseDouble(arr[i][1]);
            hakjumSum += hakjum;
        }

        //평균 구하기
        for(int i=0; i<20; i++) {
            allSum += Double.parseDouble(arr[i][1]) * Double.parseDouble(arr[i][2]);
        }
        System.out.println(allSum/hakjumSum);
    }
}
