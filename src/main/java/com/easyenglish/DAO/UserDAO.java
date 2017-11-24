package com.easyenglish.DAO;

import com.easyenglish.Models.User;

public interface UserDAO {
	public boolean userLoginWith(String username, String password);
	public User getUserWiThUsername(String username);
}
