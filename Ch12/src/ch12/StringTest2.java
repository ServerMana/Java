package ch12;

public class StringTest2 {
	public static void main(String[] args) {
		String s1 = "Java Korea";
		String s2 = new String("Java Korea");
		String s3 = s2.intern();//단축 초기화 문자열로 바꾸어 주는 메소드
		String s4 = "Java Korea";
		String s5 = new String("Java Korea");
		
		
		System.out.println("s1과 s2가 같은 장소? :"+(s1==s2));
		System.out.println("s1과 s2가 값이 같은가? :"+(s1.equals(s2)));
		System.out.println("s1과 s3가 같은 장소? :"+(s1==s3));
		System.out.println("s1과 s5가 같은 장소? :"+(s3==s5));
		System.out.println("s2와 s5의 값이 같은가? :"+(s2.equals(s5)));
		
		
		
		
	}
}
