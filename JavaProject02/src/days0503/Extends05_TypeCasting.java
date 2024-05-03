package days0503;
class NormalA{ }
class NormalB{ }
class SuperC{
   int superNum;
   void abc() { System.out.println("super method"); }
}
class SubC extends SuperC{
   int subNum;
   void abc() { System.out.println("sub method"); }
}
public class Extends05_TypeCasting {

   public static void main(String[] args) {
      SuperC super1= new SuperC();
      SubC sub1 =new SubC();
      super1.superNum = 100;
      super1.abc(); //"super method";
      sub1.superNum=20;
      sub1.subNum=20;
      sub1.abc(); // "sub method";
      
      // 객체 간의 TypeCasting #1
      // 객체간에는 "부모클래스의 참조변수"에 "자식 클래스의 인스턴스주소(new Sub())"를 저장하면 별도의 연산없이 가능
      SuperC super2= sub1;
      SuperC super3 = new SubC();
      // 부모참조변수 <- 자식 인스턴스의 주소 OK
      super3.superNum = 10; // O
      // super3.subNum = 20; // X 부모참조변수는 자신이 물려준 메소드만 접근이 가능합니다.
      super3.abc(); //SubC의 오버라이딩 된 메소드가 실행
      
      // 객체 간의 TypeCasting #2
      // 자식클래스의 참조변수에 부모클래스의 인스턴스의 주소는 "아무런 조치 없이" 저장할 수 없습니다.
      // SubC sub4 = super1; // X
      // SubC sub5 = new SuperC(); // X
      // 자식참조변수 <- 부모 인스턴스의 주소 X 
      
      // 객체 간의 TypeCasting #3
      // 자식클래스의 참조변수에 부모클래스의 인스턴스의 주소는 별도의 조치로 저장 가능합니다.
      // SubC sub4 = (SubC) super1;
      // SubC sub5 = (SubC) new SuperC();
      // 문법으로는 오류가 없지만 실행상 오류가 발생 -> 런타임 오류
      // 부모인스턴스가 강제캐스팅(SubF)를 해서 아무리"자식인척해도" 언젠가는 부모인게 들통난다는 뜻입니다.
      
      // 객체 간의 TypeCasting #4
      // 자식클래스의 참조변수 <- 부모클래스의 참조변수값 : 이 동작은 위에서 봤듯이 안되는 동작이지만
      // 만약 부모클래스 참조변값이 저장하고 있는 참조 값이 자식 클래스 인스턴스의 참조값이라면 이건 가능하게 됩니다.
      SuperC super4 = new SubC(); // 부모참조변수에 자식 인스턴스 저장
      SubC sub5 = (SubC)super4;  // 이건 아무 에러없이 실행 
      // 결과적으로 자식 인스턴스 주소를 자식 참조변수에 저장한 셈이 되므로 정상 실행
      
      // 자식인스턴스의 주소 => 부모 참조변수 => (타입캐스팅) => 자식 참조 변수 ok
      // 부모인스턴스의 주소 => 부모 참조변수 => (타입캐스팅) => 자식 참조 변수 X 런타임 에러
      
      // 부모참조변수가 자식인스턴스가 저장된 경우
      // 부모가 물려준 멤버 변수 이외에는 접근이 안됩니다.
      SuperC super6= new SubC();
      // super6.subNum = 10; //X
      
      // 당장 현재 super 6에 저장된 new Subc()의 subNum 을 사용하고자 한다면
      // 자식 클래스 참조 변수에 옮겨 저장하여 사용합니다.
      // 그러려면 #4에서 헌급한 타입캐스팅이 필요합니다
      SubC sub6= (SubC)super6;
      sub6.superNum = 20;
      
      // 객체간의 TypeCasting #5
      // 위에 같이 타입캐스팅을 통해서 변수들끼리 자료를 이동시킬때
      // 캐스팅이 가능한 지, 아니면 런타임 에러가 생길지를 판단해주는 명령이 있습니다.
      SuperC super7 = new SubC();
      SubC sub7;
      if( super7 instanceof SubC) {
         sub7 = (SubC)super7;
         System.out.println("super7 형변환 성공!");
      }else {
         System.out.println("super7 형변환 실패!");
      }
      
      SuperC super8 = new SuperC();
      SubC sub8;
      if( super8 instanceof SubC) {
         sub8 = (SubC)super8;
         System.out.println("super8 형변환 성공!");
      }else {
         System.out.println("super8 형변환 실패!");
      }

      
      //-------------------------------------------
      // 형변환
      // 기본자료의 형변환
      short s =10;
      int i = s; // 작은 용량의 자료를 큰 용량의 변수에 이동
      short k = (short)i; // 작은 용량의 변수에 큰 용량의 자료를 대입.
      double d = 25 / (double)i;
      //String str = (String)i;
      //int p = (int)"123"; // int p = Integer.parseInt("123");
      
      NormalA a1 = new NormalA();
      NormalB b1 = new NormalB();
      //NormalA a2 = b2; // x
      //NormalA a2 = (NormalA)b2; //x
   }

}