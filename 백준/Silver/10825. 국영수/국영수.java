import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Elem[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        a = new Elem[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = new Elem();
            a[i].name = st.nextToken();
            a[i].korean = Integer.parseInt(st.nextToken());
            a[i].english = Integer.parseInt(st.nextToken());
            a[i].math = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        for(int i=0; i<N; i++) {
            sb.append(a[i].name);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            if(korean != other.korean) return other.korean - korean;
            if(english != other.english) return english - other.english;
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }
}