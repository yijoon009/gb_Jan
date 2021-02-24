package prac.day02;
/*
 * CREATE TABLE tbl_member(
	num NUMBER NOT NULL,
	name varchar2(200),
	birthday DATE,
	CONSTRAINT member_pk PRIMARY KEY(num)
);
 * */
public class MemberDTO {
	private int number;
	private String name;
	private String birthday;
	
	public MemberDTO() {
		this.name = "이름이 없습니다.";
		this.birthday = "생일이 등록되지 않았습니다.";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
