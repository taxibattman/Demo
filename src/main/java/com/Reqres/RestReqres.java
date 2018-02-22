package com.Reqres;

import com.Reqres.Delete.Delete;
import com.Reqres.Login.Login;
import com.Reqres.Patch.Patch;
import com.Reqres.Put.Put;
import com.Reqres.Register.Register;
import com.Reqres.Resource.Resource;
import com.Reqres.User.User;

public class RestReqres {
	
	public final static String baseUrl = "https://reqres.in";
	
	public static Register register() {
		return new Register();
	}
	
	public static User user() {
		return new User();
	}
	
	public static Resource resource() {
		return new Resource();
	}
	
	public static Delete delete() {
		return new Delete();
	}
	
	public static Login login() {
		return new Login();
	}
	
	public static Put put() {
		return new Put();
	}
	
	public static Patch patch() {
		return new Patch();
	}
}