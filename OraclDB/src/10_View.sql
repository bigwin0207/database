
-- *오라클 - 뷰(View)
-- 물리적인 테이블에 근거한 논리적인 "가상테이블."-> 저장되어있는select문
-- 가상이란 단어는 실질적으로 데이터를 저장하고 있지 않기 때문에 붙인 것이고,
-- 테이블이란 단어는 실질적으로 데이터를 저장하고 있지 않더라도 사용계정자는 마치
-- 테이블을 사용하는 것과 동일하게 뷰를 사용할 수 있기 때문에 붙인 것

-- 뷰는 기본테이블에서 파생된 객체로서 기본테이블에 대한 하나의 쿼리문임
-- 실제 테이블에 저장된 데이터를 뷰를 통해서 볼 수 있도록 함.

-- 사용자에게 주어진 뷰를 통해서 기본 테이블을 제한적으로 사용하게 됨
-- 뷰는 이미 존재하고 있는 테이블에 제한적으로 접근하도록 한다.

-- 뷰 생성 방법
create or replace view 뷰이름 as select 조회명령(select~)

create or replace view empinfo as
select a.empno, a.ename, a.deptno, b.dname, b.loc
from emp a, dept b
where a.deptno = b.deptno;

select*from empinfo;

-- rentlist, memberlist, booklist 가 조인된 결과는 report 라는 이름의 뷰를 생성하세요
-- 대여일자, 대여도서번호, 제목, 대여 회원번호, 이름, 매출액(rentprice-discount)
create or replace view report as 
select a.rantdate , a.bnum, b.subject, a.mnum,c.name
,(b.rentprice - a.discount) as "매출액"
from rentlist a, rentlist abooklist b, memberlist c
where a.bnum = b.booknum and a.mnum = c.membernum;


create or replace view report as
select a.rantdate as, a.bnum, b.subject, a.mnum, c.name,
(b.rentprice - a.discount) as "매출액"
from rentlist a, booklist b, memberlist c
where a.bnum = b.booknum and a.mnum = c.membernum;

select * from report;

drop view report

select*from memberlist;
select*from booklist;
select*from rentlist;
select*from report;