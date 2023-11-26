import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> noHear = new HashSet<>();//중복 안되서 HashSet
        List<String> noHearnoSee = new ArrayList<>();

        for(int i=0; i<N; i++) {
            noHear.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if(noHear.contains(name)) {
                noHearnoSee.add(name);
            }
        }

        Collections.sort(noHearnoSee);

        sb.append(noHearnoSee.size() + "\n");
        for(int i=0; i<noHearnoSee.size(); i++) {
            sb.append(noHearnoSee.get(i) + "\n");
        }
        System.out.println(sb);
    }
}
