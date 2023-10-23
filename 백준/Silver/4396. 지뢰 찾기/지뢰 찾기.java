import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char arr[][], cur_arr[][];
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean isBomb = false;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        cur_arr = new char[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                cur_arr[i][j] = s.charAt(j);
            }
        }

        Loop:
        for(int a=0; a<n; a++) {
            for (int b=0; b<n; b++) {
                if (arr[a][b] == '*' && cur_arr[a][b] == 'x') {
                    isBomb = true;
                    bomb_yes();
                    break Loop;
                }
            }
        }
        if(isBomb == false) bomb_no();
        System.out.println(sb);
    }

    static void bomb_yes() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == '.' && cur_arr[i][j] == 'x') {
                    int bomb_cnt = 0;
                    for(int a=0; a<8; a++) {
                        int x = i+dx[a];
                        int y = j+dy[a];

                        if(x<0 || y<0 || x>=n || y>=n ) continue;
                        if(arr[x][y] == '*') bomb_cnt++;
                    }
                    //어떤 배열을 출력할지
                    arr[i][j] = Character.forDigit(bomb_cnt, 10);
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
    }

    static void bomb_no() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == '.' && cur_arr[i][j] == 'x') {
                    int bomb_cnt = 0;
                    for(int a=0; a<8; a++) {
                        int x = i+dx[a];
                        int y = j+dy[a];

                        if(x<0 || y<0 || x>=n || y>=n ) continue;
                        if(arr[x][y] == '*') bomb_cnt++;
                    }
                    //어떤 배열을 출력할지
                    cur_arr[i][j] = Character.forDigit(bomb_cnt, 10);
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(cur_arr[i][j]);
            }
            sb.append("\n");
        }
    }
}