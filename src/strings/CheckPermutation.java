package strings;

public class CheckPermutation {
	
	static boolean check(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return false;
		}
		
		if(s1.length() != s2.length()) {
			return false;
		}
		int[] arr = new int[26];
		for(int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			int index = c -'a';
			arr[index]++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			int index = s2.charAt(i) - 'a';
			arr[index]--;
			if(arr[index] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(check("adc", "acde"));
	}

}
