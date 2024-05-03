package days0503;

class SuperA{
	int superNum;
	SuperA(){
		System.out.println("SuperA 의 생성자가 호출 되었습니다");
	}
}
class SubA extends SuperA{
	int subNum;
	SubA(){
		// 자식 클래스의 생성장의 첫번째 명령어 super(); 가 숨어있으며, 
		// 이는 부모생성자를 호출하는 명령입니다.
		// 이 super(); 명령은 따로 끄집어내서 직접 써줄수도 있습니다.
		super();
		// 꺼내어 쓰려면 반드시 첫번째 명령으로 써줍니다.
		// 부모클래스 생성자를 모두 실행한 후 자식클래스 생성자의 남은 명령을 실행합니다.
		System.out.println("SubA 의 생성자가 호출 되었습니다");
	}
}
public class Extends02 {

	public static void main(String[] args) {
		
		SubA s1 = new SubA();
		
	}

}
