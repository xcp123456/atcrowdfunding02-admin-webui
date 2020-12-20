package com.atguigu.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Test
	public void testRoleSave() {
		for(int i=0;i<=235;i++) {
			roleMapper.insert(new Role(null,"role"+i));
		}
	}
	
	@Test
	public void testDataSource() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	
	
	@Test
	public void test() {
		System.out.println("================:"+null==null);
	}
	@Test
	public void testInsertAdmin() {
		for(int i = 1;i<238;i++) {
			Admin admin = new Admin(i,i+"",CrowdUtil.md5(i+""),"tom"+i,"tom@qq.com"+i,null);
			int count = adminMapper.insert(admin);
		}
//		System.out.println(count);
	}
	
	@Test
	public void testLog() {
		Logger logger = LoggerFactory.getLogger(CrowdTest.class);
		
	}
	
	@Test
	public void  testTx() {
		Admin admin = new Admin(null,"Jereery11","123123","��ķ","tom@qq.com",null);
		adminService.save(admin);
	}
	
	
}
