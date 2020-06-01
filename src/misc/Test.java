package misc;

import java.util.Arrays;

public class Test {
	
	public Test() {
		Float[] arr = {1f, 2f, 5f, 3f, null};
		
		Arrays.sort(arr, (o1, o2)-> {
			if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
		});
		
		for(Float n : arr) {
			System.out.println(n);
		}
		
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
