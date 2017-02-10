package com.snoopy.forum.dao;


import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext( {"classpath:/snoopyforum-dao.xml" })
public class BaseDaoTest extends UnitilsJUnit4 {
    @Test
    public void testaaa(){
        System.out.println("测试............................");
    }
	
}
