package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Member_Select {

	public static void main(String[] args) {
		MemberDao mdao = new MemberDao();
		
		
		ArrayList<MemberDto>list = mdao.getMemberlist();
		
		System.out.println("아이디\t비밀번호\t이름\t전화번호\t이메일");
		System.out.println("----------------------------------------------");
		for(MemberDto mdto : list)
			System.out.printf( mdto.getUserid(),mdto.getPwd(),mdto.getName(),mdto.getPhone(),mdto.getEmail()
					);
					

				
			
	
	}


}

