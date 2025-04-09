import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String sentence;
    static boolean isTrue;
    static char[] stack;
    static int top;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            sentence = br.readLine();
            isTrue = true;
            stack = new char[sentence.length()];
            top = -1;

            if(sentence.equals(".")) break;

            for(int i=0; i<sentence.length(); i++) {
                char c = sentence.charAt(i);
                if(c == '(' || c == '[') {
                    stack[++top] = c;
                } else if(c == ')') {
                    if(top == -1 || stack[top] != '(') {
                        isTrue = false;
                        break;
                    }
                    top--;
                } else if(c == ']') {
                    if(top == -1 || stack[top] != '[') {
                        isTrue = false;
                        break;
                    }
                    top--;
                }
            }
            if(top != -1) isTrue = false;
            
            if(isTrue) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
