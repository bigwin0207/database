package Test;

import java.util.ArrayList;

public class Board_select {

	public static void main(String[] args) {
		BoardDao bdao = new BoardDao();
		
		
		ArrayList<boardDto>list = bdao.getboardlist();
		
		System.out.println("아이디\t비밀번호\t이름\t전화번호\t이메일");
		System.out.println("----------------------------------------------");
		for(boardDto bdto : list)
			System.out.printf("%dt%s\t%s\t%s\t%s\t%s\t%s\n", bdto.getBoardnum(),bdto.getWriter(),bdto.getSubject(),bdto.getContent(),bdto.getWrite()
					);
		

	}

}
