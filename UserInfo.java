package designation.details;

public class UserInfo {
	private String name;
	private String eMail;
	private int userId;
	private String userType;
	private String password;

	public UserInfo() {

	}

	public UserInfo(String name, String eMail, int userId, String userType, String password) {
		this.name = name;
		this.eMail = eMail;
		this.userId = userId;
		this.userType = userType;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
