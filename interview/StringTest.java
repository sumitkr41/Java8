package interview;


public class StringTest {
	
	
	
	public static void main(String args[]) {
		checkString();
		
		String s = "qwertyuio";
		System.out.println("Reverse of "+s+" : "+reverse(s));
	}
	
	private static void checkString() {
		String s1 = new String("Sumit");
		String s2 = new String("Sumit");
		
		StringBuffer s3 = new StringBuffer("Sumit");
		StringBuffer s4 = new StringBuffer("Sumit");
		
		System.out.println("s1 equal s2" + (s1.equals(s2)));
		System.out.println("s1 == s2" + (s1==s2));
		
		System.out.println("s3 equal s4" + (s3.equals(s4)));
		System.out.println("s3 == s4" + (s3==s4));
	}
	
	public static String reverse(String s) {
		char rev[] = s.toCharArray();
		StringBuilder sb = new StringBuilder("");
		for(int i=rev.length-1;i>=0;i--) {
			sb.append(rev[i]);
		}
		return sb.toString();
	}

}
