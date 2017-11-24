package com.easyenglish.Services;

import com.easyenglish.Models.User;

public interface UserService {
	public boolean userLoginWith(String username, String password);
	public User getUserWithUsername(String username);
}
