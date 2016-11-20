package com.jacoco.user;

import java.util.regex.Pattern;

import com.jacoco.pojo.UserPOJO;

public class CredentialTest {
	private final UserPOJO user;
	public CredentialTest(UserPOJO user) {
		this.user = user;
	}
	
	public boolean validateUser(String username, String password){
		
		if (username == null || password == null)
			return false;
		
		if (username.trim().length() == 0 || password.trim().length() == 0)
			return false;
		
		/**
		 * TO-DO
		 * Case to validate if user exists in database. 
		 * Validate if userId and password match the one in database
		 * @return boolean
		 */
		
		return true;
	}

	public boolean signNewUser() {
		if(null == user)
			return false;
		if(null == user.getName() || null == user.getId() || null == user.getPassword())
			return false;
		if(user.getName().trim().length() == 0 || user.getId().trim().length() == 0 || user.getPassword().trim().length() == 0)
			return false;
		
		//validate password format to match alphanumeric
		// create a regex pattern for matching alphanumeric string of number (should have atleast 1 number), 
		//special char (atleast 1 special character) and alphabets(at least 1 capital) and length >= 8
		final String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}"; 
		if(Pattern.matches(regex, user.getPassword())) {
			//add user to database and return success or failure of insert into db operation
			int insert = 0; // insert will return 0  or 1 based on success failure. assume it's true for now
			return insert == 0 ? true : false;
		} else
			return false;
	}

	public boolean loginUser() {
		if(null == user)
			return false;
		if(null == user.getId() || null == user.getPassword())
			return false;
		if(user.getId().trim().length() == 0 || user.getPassword().trim().length() == 0)
			return false;
		
		//validate if user-id and password match the record from database and return boolean as true or false.
		//based on the return int value. For now, assume it is always validated by the db and return true
		int validate = 0; //  will be 0 if record matches with db else 1
		return validate == 0 ? true : false;
	}
}