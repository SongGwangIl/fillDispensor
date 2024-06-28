package kr.ac.kopo.user;

public class UserVO {
	private String userId;
	private String userPwd;
	private String userEmail;
	private char userValid;
	private char deviceRegist;
	private String userSelect;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public char getUserValid() {
		return userValid;
	}
	public void setUserValid(char userValid) {
		this.userValid = userValid;
	}
	public char getDeviceRegist() {
		return deviceRegist;
	}
	public void setDeviceRegist(char deviceRegist) {
		this.deviceRegist = deviceRegist;
	}
	public String getUserSelect() {
		return userSelect;
	}
	public void setUserSelect(String userSelect) {
		this.userSelect = userSelect;
	}
	
	
}
