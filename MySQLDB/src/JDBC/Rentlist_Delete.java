package JDBC;

import java.util.Scanner;

public class Rentlist_Delete {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstence();
	
		System.out.print(" 삭제할 대여기록의 번호를 입력하세요 : ");
		int numseq = Integer.parseInt(sc.nextLine());
		RentDto rdto = rdao.getRent(numseq);
					
		// 기록이 있는지 확인합니다. 없으면 종료
		if(rdto == null ) {
			System.out.println("해당 대여기록이 없습니다. 프로그램을 종료합니다");
		  return;
		} 
		int result = rdao.deleteRent(numseq);
		if(result == 1)System.out.println("삭제가 완료되었습니다");
		else System.out.println("삭제가 실패하였습니다.");
		

	}

}
