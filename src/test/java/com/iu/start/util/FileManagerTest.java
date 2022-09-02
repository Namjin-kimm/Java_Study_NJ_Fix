package com.iu.start.util;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iu.start.MyAbstractTest;

//@WebAppConfiguration
public class FileManagerTest extends MyAbstractTest{
	@Autowired
	private FileManager fileManager;
	
	@Test
	public void setFileTest()throws Exception {
//		fileManager.saveFile(, "resources/upload/test", null);
		System.out.println("Finish");
	}

}
