package strings;

public class StringCompression {

	static String compress(String s) {
		
		int i = 0;
		String res = "";
		boolean isRequired = false;
		while(i < s.length()) {
			int count = 1;
			char c = s.charAt(i);
			res += c;
			while((i+1) < s.length() && s.charAt(i+1) == c) {
				count++;
				i++;
			}
			if(count != 1) {
				isRequired = true; 
			}
			res += count +"";
			i++;
		}
		if(isRequired)
			return res;
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(compress("aabc"));
	}
}
