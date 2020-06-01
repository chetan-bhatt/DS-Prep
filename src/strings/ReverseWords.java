package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

	static String reverse(String s) {
		char[] charArr = s.toCharArray();
		int start = 0;
		for(int i = 0; i < charArr.length; i++) {
			if(charArr[i] == ' ') {
				swap(charArr, start, i-1);
				start = i+1;
			}
		}
		swap(charArr, start, charArr.length-1);
		swap(charArr, 0, charArr.length-1);
		return new String(charArr);
	}
	
	static void swap(char[] arr, int i, int j) {
		while(i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("Alice likes Bob"));
		
		String s1 = "ironman";
		String s2 = "i love leetcode";
		List<String> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
