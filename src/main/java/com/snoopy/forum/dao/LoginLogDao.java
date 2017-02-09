package com.snoopy.forum.dao;

import com.snoopy.forum.domain.LoginLog;
import org.springframework.stereotype.Repository;

/**
 * Post的DAO类
 *
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
	public void save(LoginLog loginLog) {
		this.getHibernateTemplate().save(loginLog);
	}

}
