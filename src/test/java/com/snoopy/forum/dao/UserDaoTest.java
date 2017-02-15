package com.snoopy.forum.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import com.snoopy.forum.domain.User;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import com.snoopy.forum.test.dataset.util.XlsDataSetBeanFactory;


public class UserDaoTest extends BaseDaoTest {

	@SpringBean("userDao")
	private UserDao userDao;


	@Test
	@DataSet("BaobaoTao.Users.xls")//准备数据 
	public void findUserByUserName() {
		User user = userDao.getUserByUserName("tony");
		assertNull("不存在用户名为tony的用户!", user);
		user = userDao.getUserByUserName("jan");
		assertNotNull("Jan用户存在！", user);
		assertEquals("jan", user.getUserName());
//		assertEquals("123456",user.getPassword());
		assertEquals(10,user.getCredit());
	}

	// 验证数据库保存的正确性
	@Test
//	@DataSet("BaobaoTao.SaveUser.xls")
	@ExpectedDataSet("BaobaoTao.ExpectedSaveUser.xls")// 准备验证数据
	public void saveUser()throws Exception  {

//		//硬编码创建测试实体
//		User u = new User();
//		u.setUserId(1);
//		u.setUserName("tom");
//		u.setPassword("123456");
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		u.setLastVisit(simpleDateFormat.parse("2016-06-06 08:00:00"));
//		u.setCredit(30);
//		u.setLastIp("127.0.0.1");
//
		//通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
		User u  = XlsDataSetBeanFactory.createBean(UserDaoTest.class,"BaobaoTao.SaveUser.xls", "t_user", User.class);
		userDao.save(u);  //执行用户信息更新操作
	}
	
	//验证数据库保存的正确性
	//@Test
	//@ExpectedDataSet("BaobaoTao.ExpectedSaveUsers.xls")// 准备验证数据
	public void saveUsers()throws Exception  {
		List<User> users  = XlsDataSetBeanFactory.createBeans(UserDaoTest.class,"BaobaoTao.SaveUsers.xls", "t_user", User.class);
		for(User u:users){
		     userDao.save(u);
		}
	}

}
