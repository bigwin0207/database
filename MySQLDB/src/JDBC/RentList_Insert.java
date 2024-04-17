package JDBC;

import java.util.Scanner;

public class RentList_Insert {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstence();
		
		String membernum;
		
		while(true) {
		System.out.print("대여할 회원의 회원번호를 입력하세요 : ");
		membernum =sc.nextLine();
		int result = rdao.memberOk(membernum); // 입력한 멤버번호가 존재하면 1 없으면 0을 리턴한다.
		if(result == 0 ) {
			System.out.println("해당 회원이 없습니다. 다시 입력하세요");
			continue;
		}else
			break;
		
		} System.out.println("입력된 회원 번호 : " + membernum + "\n");
		
		String booknum;
		while(true) {
			System.out.print("대여할 도서의 도서번호를 입력하세요 : ");
			booknum =sc.nextLine();
			int result = rdao.bookOk(booknum); // 입력한 멤버번호가 존재하면 1 없으면 0을 리턴한다.
			if(result == 0 ) {
				System.out.println("해당 도서가 없습니다. 다시 입력하세요");
				continue;
			}else
				break;
			} System.out.println("입력된 도서 번호 : " + booknum + "\n");
			
			
		}

}
