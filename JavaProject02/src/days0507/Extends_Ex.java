package days0507;

import java.util.ArrayList;

//상품구매시스템
//클래스 제작 및 운영 대상 : 판매할 상품들, 구매자
//판매할 상품 : 컴퓨터 TV Audio
//각 클래스에는 적절한 멤버변수와 멤버메서드를 만들어서 운영하되
//공통의 요소들이 있다면 부모클래스를 만들고 그를 상속받아서 사용합니다.
class Product{
   int price;
   int bonusPoint;
   Product(int p){
      price = p;
      bonusPoint = (int)(price * 0.1);
   }
}
class Computer extends Product{
   Computer(int p){
      super(p);
   }
   public String toString() {
      return "Computer";
   }
}
class Tv extends Product{
   Tv(int p){
      super(p);
   }
   public String toString() {
      return "Tv";
   }
}
class Audio extends Product{
   Audio(int p){
      super(p);
   }
   public String toString() {
      return "Audio";
   }
}
class Buyer{
	int money =10000000;
	int bonusPoint;
	ArrayList itemList = new ArrayList();
	
	// 메소드를 오버로딩하여 구매 메소드 구현
	//public void buy(Computer c) { }
	//public void buy(Tv t) { }
	//public void buy(Audio a) {}
	public void buy(Product p) {
		// this 가 p를 구매하는 명령들을 기술합니다.
		// 제품가격 보다 구매자의 소지금액이 많아서 구매에 오류는 없을지 점검
		if(this.money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		// 제품 가격만큼 구매자 잔액을 차감
		this.money -= p.price;
		
		// 제품의 보너스만큼 구매자의 보너스 포인트를 합산
		this.bonusPoint += p.bonusPoint;
		
		// 구매상품을 itemList 에 저장
		itemList.add(p);
		
		System.out.println(p + "를 구매하셨습니다. ");
	}

	public void summary() {
		int sum = 0; // 지출 총액을 합산할 변수
		String item = ""; // 구입한 상품들을 화면에 나열하기 위해 준비한 String 변수
		if( itemList.isEmpty()) {
			System.out.println("구매하신 제품이 없습니다");
			return;
		}
		for(int i=0; i < itemList.size(); i++) {
			Product p = (Product)itemList.get(i);
			sum += p.price;
			item += p.toString() + ",";
		}
		System.out.println(" 구매 Summary-----------");
		System.out.println("지출총액 : " + sum );
		System.out.println("구매목록 : " + item);
		System.out.println("보유잔액 : " + this.money);
		System.out.println("보유 보너스 포인트 :" + this.bonusPoint);
	}
	
}

public class Extends_Ex {
   public static void main(String[] args) {
      //new로 만든건 기본 0, null로 채워짐
      Computer c = new Computer(1500000);
      Tv t = new Tv(1000000);
      Audio a = new Audio(800000);
      
      Buyer b = new Buyer();
      b.buy(c);
      b.buy(t);
      b.buy(a);
      b.summary();
   }
}