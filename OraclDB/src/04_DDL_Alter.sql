
-- 생성
create table 테이블 이름();
create user scott identified by tiger;

-- 수정
alter table 테이블 이름<수정내용>;
alter user 유저이름 identified by 비밀번호;

-- 1. 필드명의 변경
ALTER TABLE 테이블 이름 RENAME COLUMN 변경전 필드이름 TO 변경후 필드 이름;

-- booklist 테이블의 subject 필드명을 title 로 수정합니다.
ALTER TABLE booklist RENAME COLUMN subject TO title;
SELECT* FROM booklist;

-- 반대로 title 필드명을 sbject 필드명으로 수정합니다.
alter table booklist RENAME COLUMN  title TO subject;

-- rentlist 의 outprice 필드의 이름을 rentprice로 수정하세요
alter table booklist RENAME COLUMN outprice TO rentprice;

-- memberlist 테이블의 membername 필드를 name 으로 변경하세요
alter table memberlist RENAME COLUMN membername TO name;

-- rentlist 테이블의 rent_date 필드를 rantdate로 변경하세요
alter table rentlist RENAME COLUMN rent_date TO rantdate;

-- rentlist idx를 numseq로 변경하세요
alter table rentlist RENAME COLUMN idx TO numseq;

-- 2. 필드 자료형의 변경
-- ALTER TABLE 테이블명 MODIFY 필드명 자료형 [디폴트값이나 제약사항]

-- varchar2(12)였던 memberlist 테이블의 name 필드를 carchar2(30)으로 변경
alter table memberlist modify name varchar2(30);

-- booklist 의 booknum필드를 number(5) 로 자료형 변경
alter table booklist modify booknum number(5); --수정실패

-- memberlist의 membernum필드를 number(5) 로 자료형 변경
alter table memberlist modify membernum number(5); -- 수정실패

-- rentlist의 bnum 필드를 number(5) 로 자료형 변경
alter table rentlist modify bnum number(5); -- 수정실패

-- rentlist의 mnum 필드를 number(5) 로 자료형 변경
alter table rentlist modify mnum number(5); -- 수정실패

-- 외래키로 연결되어서 참조되고, 참조하고 있는 필드들은 위의 명령으로 수정이 바로 불가능 합니다.
-- 가능하게 하려면, 외래키 제약 조건을 수정하여 없애버리고, 참조되는 필드와 참조하는 칠드를
-- 모두 수정한 후 외래키 제약조건을 다시 설정합니다.
-- alter 명령에 의해서 제약조건을 수정 또는 삭제하는 명령을 아래에서 학습합니다.

-- 3. 필드의 추가
-- ALTER TABLE 테이블명 ADD 필드명 자료형

-- booklist에 구매등급을 저장할 수 있는 grade 필드를 varchar2(15)로 추가
alter table booklist add grade varchar2(15);

--memberlist 에 성별(gender)필드를 varchar2(3)으로 추가
alter table memberlist add gender varchar2(3);

--memberlist 에 나이(age) 필드를 number(2)로 추가
alter table memberlist add age number(2);

-- 4. 필드의 삭제
-- ALTER TABLE 테이블명 DROP COLUMN 필드명

-- memberlist 테이블에서 성별 필드 제거
-- alter table memberlist drop column gender;

-- 5. 제약조건의 추가 / 삭제
-- 필드 레벨의 제약조건의 수정 -> modify 명령을 통해서 수정/생성/삭제 합니다.
-- memberlist 의 gender 필드에 'M' 또는 'F' 둘 중에 하나만 입력되게 제약조건을 설정한다면
alter table memberlist modify gender varchar2(3) check(gender = 'M' or gender ='F');
alter table memberlist modify gender varchar2(3) check(gender in('M','F'));
--gender in('F','M') : gender 필드값이 in 함수안에 있는 값들일때만 true를 결과로.

--테이블 레벨의 제약조건 생성
--추가 : ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건식
--테이블 LEVEL 의 제약 조건은 위의 명령 형식으로 제약조건 이름과 함께 추가합니다.

--memberliste 테이블의 나이(age) 필드에 120살이 초과되는 나이는 입력되지 못하게 제약조건 추가
alter table memberlist add constraint check_age check(age <= 120 );

-- 테이블 레벨의 제약조건 삭제
-- 삭제 : alter table 테이블명 drop constraint 제약조건명

--rentlist 테이블의 bnum 에 걸려있는 외래키 제약조건 제거 (fk1)
alter table rentlist drop constraint fk1;

--rentlist 테이블의 mnum 에 걸려있는 외래키 제약조건 제거 (fk2)
alter table rentlist drop constraint fk2;

--rentlist 테이블의 기본키 제거(rent_pk)
alter table rentlist drop constraint rent_pk;




-- booklist 의 booknum필드를 number(5) 로 자료형 변경
alter table booklist modify booknum number(5); 

-- memberlist의 membernum필드를 number(5) 로 자료형 변경
alter table memberlist modify membernum number(5); 

-- rentlist의 bnum 필드를 number(5) 로 자료형 변경
alter table rentlist modify bnum number(5); 

-- rentlist의 mnum 필드를 number(5) 로 자료형 변경
alter table rentlist modify mnum number(5); 

--rentlistg의 기본키를 (rent_pk)numseq 로 설정
alter table rentlist add constraint rent_pk primary key(numseq)
-- rentlist 의 외래키 fk1, fk2 재설정
alter table rentlist add constraint fk1 foreign key(bnum) references booklist(booknum);

alter table rentlist add constraint fk2 foreign key(mnum) references memberlist(membernum);

-- 테이블 생성 EX
-- 테이블명 : ORDERS1
-- 필드 : 
-- ORDER_ID 	NUMBER(12,0)            ORDER_DATE   DATE
-- ORDER_MODE 	VARCHAR2(8)    		CUSTOMER_ID  NUMBER(6,0)
-- ORDER_STATUS NUMBER(2,0)			ORDER_TOTAL  NUMBER(8,2)
-- SALES_REP_ID NUMBER(6,0)				PROMOTION-ID NUMBER(6,0)	

--제약사항 :
--기본키 ORDER_ID - 테이블레벨(제약명 : pk_order)
-- ORDER_MODE에는 'direct','online'만 입력가능 - 테이블레벨(제약명 : ck-order_mode)
-- ORDER_TOTAL의 디폴트 값은 0 - 필드레벨
-- ORDER_DATE 디폴트값 오늘 날짜 - 필드레벨

create table ORDERS1(
		ORDER_ID NUMBER(12,0) ,
		ORDER_MODE VARCHAR2(8),
		ORDER_STATUS NUMBER(2,0),
		SALES_REP_ID 	NUMBER(6,0),
		ORDER_DATE   DATE DEFAULT SYSDATE,
		CUSTOMER_ID  NUMBER(6,0),
		ORDER_TOTAL  NUMBER(8,2) default 0,
		PROMOTION_ID NUMBER(6,0),
		
constraint pk_order primary key(ORDER_ID),	
constraint CK_ORDER_MODE check(order_mode in ('direct' , 'online'))
);


-- 테이블 수정 EX
-- CUSTOMER_ID 필드명을 CUSTOMER_NUMBER로 수정
ALTER TABLE orders1 RENAME COLUMN customer_id TO customer_number;

-- Promotion_id 값은 10000 ~ 99999 사이의 값만 저장 가능
alter table orders1 add constraint pro_check check(promotion_id >= 10000 and promotion_id <= 99999);

alter table orders1 add constraint pro_check check (promotion_id between 10000 and 99999);

--테이블의 복사
create table order2 as select* from orders1;

--테이블의 제거
drop table order2 purge; --purge는 생략 가능 





 

