package com.snoopy.forum.dao;

import java.util.List;

import com.snoopy.forum.domain.Topic;
import org.junit.Test;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;


import com.snoopy.forum.test.dataset.util.XlsDataSetBeanFactory;

/**
 * topic 的DAO类
 *
 */
public class TopicDaoTest extends BaseDaoTest {
	@SpringBean("topicDao")
	private TopicDao topicDao;
	
	@Test
	@ExpectedDataSet("BaobaoTao.ExpectedTopics.xls")
	public void addTopic()throws Exception {
	    List<Topic> topics = XlsDataSetBeanFactory.createBeans(TopicDaoTest.class,"BaobaoTao.SaveTopics.xls", "t_topic", Topic.class);
	    for(Topic topic:topics){
	    	topicDao.save(topic);
	    }
	}
}
