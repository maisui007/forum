package com.baobaotao.dao;

import com.snoopy.forum.dao.PostDao;
import org.unitils.spring.annotation.SpringBean;

/**
 * Post的DAO类
 * 
 */
public class PostDaoTest extends BaseDaoTest {

	@SpringBean("postDao")
	private PostDao postDao;
}
