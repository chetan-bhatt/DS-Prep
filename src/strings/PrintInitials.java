package strings;

public class PrintInitials {
	
	static String reverse(String s) {
		
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		
		while(i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return new String(arr);
	}
	
	public static void main(String[] args) {
		
	}
}
