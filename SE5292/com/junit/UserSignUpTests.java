package com.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jacoco.pojo.UserPOJO;
import com.jacoco.user.CredentialTest;

public class UserSignUpTests {
	private static UserPOJO user = null;
	
	@BeforeClass
	public static void createUserObj() {
		user = new UserPOJO();
		user.setName("Vivek");
		user.setId("vivek123");
		user.setPassword("Vivek@123");
	}
	
	@AfterClass
	public static void destroyObj() {
		user = null;
	}
	
	@Test
	public void testUserSignUpSuccess() {
		CredentialTest testObj = new CredentialTest(user);
		assertEquals("Assert case to check successful user signup", true, testObj.signNewUser());
	}
	
	@Test
	public void testUserSignUpFailure() {
		user.setPassword("");
		CredentialTest testObj = new CredentialTest(user);
		assertNotEquals("Assert case to check failed user signup", true, testObj.signNewUser());
	}
}