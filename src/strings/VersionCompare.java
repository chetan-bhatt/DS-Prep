package strings;

public class VersionCompare {
	
	static int compare(String version1, String version2) {
		  String[] v1 = version1.split("\\.");
	        String[] v2 = version2.split("\\.");
	        
	        System.out.println(v1.length);
	        System.out.println(v2.length);
	        if(!v1[0].equals(v2[0])){
	            return v1[0].compareTo(v2[0]);
	        }

	        return -1;
	}
	
	public static void main(String[] args) {
		String version1 = "2.2.3.0.0.1";
		String version2 = "1.2.3.1";
		
		System.out.println(compare(version1, version2));

	}

}
