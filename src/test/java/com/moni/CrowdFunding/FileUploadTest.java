package com.moni.CrowdFunding;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileUploadTest {

	@Test
	public void test() {
		File file = new File("test.txt");
	 
		System.out.println(file.getAbsolutePath());
		System.out.println(file.exists());


	}

}
