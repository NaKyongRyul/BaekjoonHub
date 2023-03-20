import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    // Comparable - 인터페이스
    // 이를 사용하기 위해서는 '반드시 구현'
    // Comparable 인터페이스에는 compareTo() 메소드 하나가 선언되어 있는데 Comparable 를 사용하려면 compareTo 메소드 반드시 재정의
    static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        public int compareTo(Elem other) {
            // 국어 내림차순
            if(korean != other.korean) {
                return other.korean - korean;
            }
            // 영어 오름차순
            if(english != other.english) {
                return english - other.english;
            }
            // 수학 내림차순
            if(math != other.math) {
                return other.math - math;
            }
            // 이름 오름차순
            return name.compareTo(other.name);
        }
    }

    static int N;
    // 학생배열
    static Elem[] a;

    // 입력
    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new Elem[N];

        for(int i=0; i<N; i++) {
            a[i] = new Elem();
            a[i].name = sc.next();
            a[i].korean = sc.nextInt();
            a[i].english = sc.nextInt();
            a[i].math = sc.nextInt();
        }
    }

    // 출력
    static void pro() {
        // 기준을 통해 정렬
        Arrays.sort(a);
        // 정답 출력
        for(int i=0; i<a.length; i++) {
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
