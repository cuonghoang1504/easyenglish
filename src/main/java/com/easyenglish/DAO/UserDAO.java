package com.easyenglish.DAO;

import com.easyenglish.Models.User;

public interface UserDAO {
	public boolean userLoginWith(String username, String password);
	public User getUserWiThUsername(String username);
	public User getUserById(int user_id);
	public void addUser(User admin);
}
