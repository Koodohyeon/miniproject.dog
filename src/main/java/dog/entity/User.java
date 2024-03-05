package dog.entity;

import java.time.LocalDate;

public class User {
	private String uId;
	private String pwd;
	private String uname;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	private int balance;

	public User() { }
	

	public User(String uId, String pwd, String uname, String email) {
		this.uId = uId;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
	}


	public User(String uId, String pwd, String uname, String email, int balance) {
		this.uId = uId;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.balance = balance;
	}

	public User(String uId, String pwd, String uname, String email, LocalDate regDate, int isDeleted,
				int balance) {
		this.uId = uId;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "User [uId=" + uId + ", pwd=" + pwd + ", uname=" + uname + ", email=" + email + ", regDate=" + regDate
				+ ", isDeleted=" + isDeleted + ", balance=" + balance + "]";
	}


	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getRegDate() {
		return regDate;
	}


	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}


	public int getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	
}
