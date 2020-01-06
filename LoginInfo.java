package com.deloitte.demo.model;

public class LoginInfo {
	private int userId;
	private String password;
	private String usertype;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "loginInfo [userId=" + userId + ", password=" + password + ", usertype=" + usertype + "]";
	}

}
