package com.junit;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jacoco.pojo.UserPOJO;
import com.jacoco.user.CredentialTest;
import com.jacoco.user.ReportGeneration;

public class CodeTest {
	
private static UserPOJO user = null;
	
// Testing code execution for "Good Data" i.e user name /ID/Password are provided and in appropriate format
//---------------------------------------------------------------------------------------------------------
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
	public void testUserSignUpSuccessGoodData() {
		CredentialTest testObj = new CredentialTest(user);
		assertEquals("Assert case to check successful user signup", true, testObj.signNewUser());
	}
	
//End of a good data test	
//---------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------
	
// Testing code execution for "Bad Data" i.e user name /ID/Password are provided in appropriate format
	@Test
	public void testUserSignUpFailureBadData() {
		
		String[] testuserName = {"", "1234", "Viv1234","@viv"};	
		String[] testuserID = {"", "@#$%"};	
		String[] testuserPassword = {"", "@#$%"};
		for(String uname: testuserName){
			for(String uid: testuserID){
				for(String upass: testuserPassword){
						user.setName(uname);
						user.setId(uid);
						user.setPassword(upass);
						CredentialTest testObj = new CredentialTest(user);
						assertNotEquals("Assert case to check failed user signup", true, testObj.signNewUser());
				}
			}
		}	
	}
//End of a bad data test
//---------------------------------------------------------------------------------------------------------	
//---------------------------------------------------------------------------------------------------------	
//Testing code for Boundary analysis
	/* 
	 * For user signup credential we test for the boundry conditions in the  length, size and range of data
	 * acceptable for username/userId and user password
	 * 
	 * UserName boundary conditions :
	 * 1) Length of username should be greater than 3 Alphabets and less than 30 alphabets
	 * Case1:   Length of username equal to 3 Alphabets   //valid
	 * Case2:   Length of username just less than to 3 Alphabets
	 * Case3:   Length of username less than 3 Alphabets
	 * Case4:   Length of username equal to 30 Alphabets //valid
	 * Case5:   Length of username just greater than 30 Alphabets
	 * Case6:   Length of username greater than 30 Alphabets
	 * Case7:	Length of username less than 30 Alphabets and greater than 3 Alphabets //valid
	 * case8:   Length of username greater than 3 Alphabets and less than 30 Alphabets //valid
	 * -------------------------------------------------------------------------
	 * * UserId boundary conditions :
	 * 1) Length of UserID should be between 111111 and 999999 (both inclusive)
	 * Case1:   Length of UserID equal to 111111 //valid
	 * Case2:   Length of UserID just less than 111111
	 * Case3:   Length of UserID less than 111111
	 * Case4:   Length of UserID equal to 999999 // valid
	 * Case5:   Length of UserID just greater than 999999
	 * Case6:   Length of UserID greater than 999999
	 * Case7:   Length of UserID less than 999999 and greater than 111111 //valid
	 * Case8:   Length of UserID greater than 111111 and less than 999999 //valid
	 */
	@Test
	public void userSignupBoundaryAnalysis() {
		
		//Negative test cases in Boundary analysis
	String[] testuserName = {"vi", "ai", "v","abcdefghijklmnopqrstuvwxyzqwea","abcdefghijklmnopqrstuvwxyzqweaa",
							"abcde fghijkl mnopqrstuvwxyzqwe"};	
	String[] testuserID = {"11111", "99999","111110","1000000","9999999","1234567","99999","1111111"};	
	for(String uname: testuserName){
		for(String uid: testuserID){
					user.setName(uname);
					user.setId(uid);
					CredentialTest testObj = new CredentialTest(user);
					assertNotEquals("Assert case to check failed user signup", true, testObj.signNewUser());
				}
			}
	
	    //Positive test cases in Boundary analysis
	String[] testuserName_p = {"viv", "abcdefghijklmnopqrstuvwxyzqwe", "abcdefghijkl mnopqrstuvwxyzqw","vivek"};	
	String[] testuserID_p = {"111111", "999999","123456","111112","999998"};	
	for(String uname: testuserName_p){
		for(String uid: testuserID_p){
					user.setName(uname);
					user.setId(uid);
					CredentialTest testObj = new CredentialTest(user);
					assertEquals("Assert case to check successful user signup", true, testObj.signNewUser());
				}
			}
		}
	
//---------------------------------------------------------------------------------------------------------	
//---------------------------------------------------------------------------------------------------------	

	//Testing code for Simple Loop
		/*
		 * System loops through the userID  of all the users to check if the UserID is already taken
		 * 
		 * 
		 */
		@Test
		public void LoopTestUserID() {
			user.setName("Sandeep");
			user.setId("sds0307");
			user.setPassword("qwerty");
			CredentialTest ct = new CredentialTest(user);
			
			//Checks if userID already exists.
			assertEquals("Assert case to check userID exists", true,ct.CheckIfUserIDExists());	
		}
		
		
		//Testing All Branch Coverage
		/*
		 * System takes in the password provided by a new user and returns the validation status (message)
		 * of the password
		 */
		@Test
		public void AllBranchCoverage(){
			
			String[] ErrorsMessages = {"Password must contain atleast 1 number",
					"Password must contain atleast 1 special character",
					"Password must contain atleast 1 alphabet",
					"Password must contain atleast 1 capital letter",
					"Password must be atleast 8 characters long",
					"Valid Password"};
			
			String[] Passwords = {"qwertyAbc*","Qwerty123","123456*","qwerty123*","qwe123*","Qwerty1234*"};
			CredentialTest ct = new CredentialTest(user);
			
			for(int i =0; i<6;i++)
			{
				assertEquals("Assert case to check if password validation "
							+ "returns the right message", 
							ErrorMessages[i],ct.PasswordValidationMessage(Passwords[i]));
			}
		}
		
}
