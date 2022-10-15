package kr.co.narrator.model;

// VO와 DTO 차이
// VO 는 데이터베이스와 거리가 가까워 테이블 구조를 이용해서 작성되는 경우가 많다
// DTO 는 화면과 거리가 가까워 화면에서 전달되는 데이터(아이디, 비밀번호)를 수집하는 용도로 사용하는 경우가 많다.
public class LoginDTO {
	
	private String uid;
	private String pwd;
	private boolean useCookie;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", pwd=" + pwd + ", useCookie=" + useCookie + "]";
	}


}
