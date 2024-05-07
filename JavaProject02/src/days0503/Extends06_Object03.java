package days0503;
class Line{
   int x; int y;
   Line(int x, int y){
      this.x = x; this.y =y;
   }
   public boolean equals(Object obj) {
	      //obj와 this하고 멤버변수 x와 y를 비교해서 같으면 true 리턴, 다르면 false 리턴
	      //a1 -> this  a2 -> obj
	      //부모참조변수가 자식 인스턴스의 멤버변수에 접근이 불가능하므로 형변환이 필요합니다.
	      
	      //형변환전에 obj가 형변환이 가능한 객체인지 조회하고 다르면 false를 리턴하고 종료
	      if (!(obj instanceof Line)) return false;
	      
	      Line target = (Line)obj;
	      boolean result = (this.x == target.x) && (this.y == target.y);
	      return result;
	   }
}
public class Extends06_Object03 {

   public static void main(String[] args) {
      
      // 객체들간의 비교
      String s1 = "Hello";
      String s2 = "Hello";
      if(s1==s2) System.out.println("s1 변수와 s2 변수는 같습니다");
      else System.out.println("s1변수와 s2변수는 다릅니다 ");
      
      String s3 = new String("Hello");
      String s4 = new String("Hello");
      if(s3==s4) System.out.println("s3 변수와 s4 변수는 같습니다");
      else System.out.println("s3변수와 s4변수는 다릅니다 ");
      
      if(s3.equals(s4))System.out.println("s3 변수와 s4 변수는 같습니다.(equals)");
      else System.out.println("s3 변수와 s4 변수는 다릅니다.(equals)");
   
      Line a1 = new Line(20,30);
      Line a2 = new Line(20,30);
      if(a1==a2) System.out.println("Line 객체 a1 변수와 s2 변수는 같습니다(==)");
      else System.out.println("Line 객체 a1 변수와 s2 변수는 다릅니다(==)");
      
      if(a1.equals(a2))System.out.println("Line 객체 a1 변수와 s2 변수는 같습니다(equals)");
      else System.out.println("Line 객체 a1 변수와 s2 변수는 다릅니다(equals)");
      //a1 과 a2 가 같다고 나오려면 멤버변수 x 와 y 끼리 비교해서 같을 때 같다(true) 를 리턴하도록
      // equals 를 오버라이딩 해야합니다
   }

}