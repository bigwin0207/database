package JDBC;

import java.util.ArrayList;

public class RentList_Select{

	public static void main(String[] args) {
		
		// RentDao rdao = new RentDao(); // 생성자가 private로 묶여있어서 호출 불가
		RentDao rdao = RentDao.getInstence();
		ArrayList<RentDto>list = rdao.selectRent();
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("대여번호\t날짜\t\t\t회원번호\t성명\t\t대여가격\t할인가격\t매출액\t\t제목\n");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		for(RentDto rdto : list) { 
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t%s\n",
					rdto.getNumseq(), rdto.getRentdate(), rdto.getMnum(), rdto.getName(),
					rdto.getRentprice(), rdto.getDiscount(), rdto.getAmount(), rdto.getBnum(), 
					rdto.getSubject());

		}
	}

}
