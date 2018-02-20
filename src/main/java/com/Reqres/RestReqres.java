package com.Reqres;

import com.Reqres.Register.Register;
import com.Reqres.User.User;

public class RestReqres {
	
	public final static String baseUrl = "https://reqres.in";
	
	public static Register register() {
		return new Register();
	}
	
	public static User user() {
		return new User();
	}
}