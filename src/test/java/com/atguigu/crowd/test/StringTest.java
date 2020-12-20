package com.atguigu.crowd.test;

import org.junit.Test;

import com.atguigu.crowd.util.CrowdUtil;

public class StringTest {
	
	@Test
	public void run1() {
		String md5 = CrowdUtil.md5("1");
		System.out.println(md5);
	}
}
