package codetest;
/*
 * 작성일 :2023 09 08
 * 작성자 :박근환
 * 설명 : 추상 클래스 -동물의 울음소리 출력
 * 
 * 
 * 
 * 
 */
abstract class myAnimal
{
//abstract String sound(){} //추상 매서드의 본문을 지정하지 않아서 오류가 뜸
//추상 매소드 : 동물의 소리를 반환하는 메소드
	abstract String sound(); //추상 매서드의 본문을 지정하지 않았습니다

//일반 메소드 : 동물으 ㅣ기본 정보 출력하는 메소드
	void displayInfo() {
		System.out.println("동물의 울음 소리 입니다");
				
	}

}

//고양이 클래스 추상 클래스를 상속
class myCat extends myAnimal{

	@Override
	String sound() {
		// TODO Auto-generated method stub
		return "야옹~~";
	}
	
	
	
}
public class AnimalTest {
	public static void main(String[] args) {
	 myAnimal cat = new myCat();
     cat.displayInfo();
     System.out.println(cat.sound());
     
	}
}
