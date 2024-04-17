--12_GroupFuntion.sql

-- 테이블내의 하나의 필드값들 전체로 하는 함수

-- 합계 (sum)
select sum(inprice) as "입고가격 합계" from booklist; 
select sum(rentprice) as "대여 가격 합계" from booklist where inprice>= 18000;

-- 갯수 (count)
select count(*) as "회원 수" from memberlist;
select count(*) as "회원 수" from memberlist where bpoint<=100;

-- 평균 (avg)
select round( avg(inprice) , 0) as "입고가격 평균" from booklist;
-- to-char 로 변경된 숫자는 문자로 변경된 것이므로 명령실행 이후 숫자로서의 기능이 상실됩니다. 다른 숫자와 계산 불가
select to_char( avg(inprice) , '999,999,999') as "입고가격 평균" from booklist;

-- max : 최대값
-- sequence 에 의해서 추가된 자동 증가번호를 조회할 때 많이 사용합니다.
select max(inprice) from booklist;

-- min : 최소값
select min(inprice) from booklist;




-- group by 
-- 그룹함수의 결과들을 다른 필드의 그룹으로 재구성
select count(*)as "총대여건수" from rentlist;

-- 도서별 대여건수
select bnum as "도서번호", count(*) as "도서별 대여건수", sum(discount) as "할인금액 합계" from rentlist group by bnum;

-- rentlist 테이블에서 대여일자(rentdate) 별 대여건수와 할임금액 평균
select rantdate as 대여일자, count(*) as 대여건수
from rentlist group by rantdate order by rantdate desc;

-- having
-- 그룹핑된 내용들에 조건을 붙일 때
select rantdate as 대여일자 , count(*) as 대여건수, avg(discount) as 할인금액평균
from rentlist
group by rantdate
having avg(discount)>=150
order by rantdate desc;



