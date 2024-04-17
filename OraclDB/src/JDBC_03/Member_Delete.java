package JDBC_03;

import java.util.Scanner;

public class Member_Delete {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 멤버의 멤버번호를 입력하세요 : ");
		int membernum = Integer.parseInt(sc.nextLine());
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.getMember(membernum);
		
		if(mdto == null ) {
			System.out.println("입력한 멤버번호의 멤버가 존재하지 않습니다. \n 프로그램을 종료합니다. ");
			return ;
			}
		
		int result = mdao.deleteMember(membernum);
		if(result == 1 ) System.out.println("삭제 성공");
		else System.out.println("삭제 실패");

	}

}
