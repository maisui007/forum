package com.snoopy.forum.service;

import com.snoopy.forum.domain.User;
import com.snoopy.forum.exception.UserExistException;
import com.snoopy.forum.utils.UUIDGenerator;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.util.Date;

@SpringApplicationContext( {"snoopyforum-service.xml", "snoopyforum-dao.xml"})
public class BaseServiceTest extends UnitilsJUnit4 {
	@SpringBean("hibernateTemplate")
	public  HibernateTemplate hibernateTemplate;

	@SpringBean("userService")
	private UserService userService;

	@Test
	public void testUserService() throws UserExistException {
		userService.getUserByUserName("tom");
		User user = new User();
		user.setUserId(UUIDGenerator.generator32());
		user.setUserName("xiaohua");
		user.setUserNo("002");
		user.setCredit(100);
		user.setLastIp("127.0.0.1");
		user.setLastVisit(new Date());
		userService.register(user);

	}

}
