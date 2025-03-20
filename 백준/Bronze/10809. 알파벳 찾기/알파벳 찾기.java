import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		
		String s = sc.next();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<s.length(); j++) {
				if(arr[s.charAt(j) - 'a'] == -1) {
					arr[s.charAt(j) - 'a'] = j;
				}
			}
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

}