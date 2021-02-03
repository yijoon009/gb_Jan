CREATE TABLE STUDENT(
	ID NUMBER(8),
	NAME VARCHAR2(100),
	MAJOR VARCHAR2(200),
	GENDER CHAR(1) DEFAULT 'W' NOT NULL CONSTRAINT BAN_CHAR CHECK(GENDER IN('M','W')),
	BIRTH DATE CONSTRAINT BAN_DATE CHECK(BIRTH >= TO_DATE('1980-01-01', 'YYYY-MM-DD')),
	CONSTRAINT STD_PK PRIMARY KEY(ID)
);

SELECT * FROM STUDENT;

--DEFAULT 이용할때는 그 컬럼 빼고 추가해야해
INSERT INTO STUDENT (ID, NAME, MAJOR, BIRTH)
VALUES(1, '김이준','경영학과',TO_DATE('1991-12-04','YYYY-MM-DD'));

--DML


--PLAYER 테이블에서 TEAM_ID가 'K01'인 선수 검색
SELECT * FROM PLAYER WHERE TEAM_ID = 'K01';

--PLAYER 테이블에서 TEAM_ID가 'K01'이 아닌 선수 검색
SELECT * FROM PLAYER WHERE TEAM_ID <> 'K01';

--PLAYER 테이블에서 WEIGHT가 70이상이고 80이하인 선수 검색
SELECT * FROM PLAYER WHERE WEIGHT BETWEEN 70 AND 80;

--PLAYER 테이블에서  TEAM_ID가 'K06'이고 NICKNAME이 '체리'인 선수 검색
SELECT * FROM PLAYER WHERE TEAM_ID = 'K06' AND NICKNAME = '제리';

--PLAYER 테이블에서 HEIGHT가 170이상이고 WEIGHT가 80이상인 선수 이름 검색
SELECT * FROM PLAYER WHERE HEIGHT >= 170 AND WEIGHT >= 80;

--STADIUM 테이블에서 SEAT_COUNT가 30000초과이고 41000이하인 경기장 검색
SELECT * FROM STADIUM WHERE SEAT_COUNT > 30000 AND SEAT_COUNT <= 41000;
SELECT * FROM STADIUM WHERE SEAT_COUNT BETWEEN 30001 AND 41000;

-- PLAYER 테이블에서 TEAM_ID가 'K02'이거나 'K07'이고 포지션은 'MF'인 선수 검색
-- AND는 OR보다 우선순위가 높다
SELECT * FROM PLAYER WHERE (TEAM_ID = 'K02' OR TEAM_ID = 'K07') AND "POSITION" = 'MF';
SELECT * FROM PLAYER WHERE TEAM_ID IN('K02','K07') AND POSITION = 'MF';

--CASE문 사용
--STADIUM 테이블에서 SEAT_COUNT가 0 이상 30000이하면 'S'
--300001 이상 50000이하면 'M' 다 아니면 'L'
--CASE WHEN THEN ELSE END 미리 써놓자
--FROM 절에 AS 쓸때는 무조건 AS 생략해야해.

SELECT STADIUM_NAME 경기장, SEAT_COUNT "좌석 수", 
	CASE
		WHEN SEAT_COUNT BETWEEN 0 AND 3000 THEN 'S'
		ELSE(
			CASE 
				WHEN SEAT_COUNT BETWEEN 30001 AND 50000 THEN 'M'
				ELSE 'L'
			END
		)
	END AS 규모
FROM STADIUM;

--EMPLOYEES 테이블에서 평균 급여보다 낮은 사람들의 급여를 10% 인상하기
SELECT * FROM EMPLOYEES;
UPDATE EMPLOYEES
SET SALARY = SALARY*1.5 WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT AVG(SALARY) FROM EMPLOYEES; --6643

--EMP 테이블에서 사원의 이름과 사원의 매니저 이름 조회
SELECT * FROM EMP;
SELECT E.ENAME 사원, E1.ENAME 관리자 FROM EMP E, EMP E1 WHERE E.MGR = E1.EMPNO;



--EMP 테이블 사원번호로 DEPT 테이블의 지역 검색하기
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT E.DEPTNO, E.ENAME, D.LOC FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;




