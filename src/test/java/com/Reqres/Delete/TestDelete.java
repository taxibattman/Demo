package com.Reqres.Delete;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;

public class TestDelete {
//TODO
	@Test
	public void testDelete() {
		RestReqres.delete().deleteData();

	}
}
