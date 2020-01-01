package designation.details;

import java.util.ArrayList;

public class Users {
	
	public UserInfo loginCheck(int userId,String password,ArrayList<UserInfo> userDb) {
		
		for(UserInfo user:userDb) {
			if(userId==user.getUserId()) {
				if(password.matches(user.getPassword())) {
					return user;
				}
				else {
					return null;
				}
			}
		}
		return null;
		
		
	}
	

}
