//package org.yyj.testmybatis;  
//  
//import javax.annotation.Resource;  
//  
//import org.apache.log4j.Logger;  
//import org.junit.Before;  
//import org.junit.Test;  
//import org.junit.runner.RunWith;  
//import org.springframework.context.ApplicationContext;  
//import org.springframework.context.support.ClassPathXmlApplicationContext;  
//import org.springframework.test.context.ContextConfiguration;  
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
//  
//import com.alibaba.fastjson.JSON;  
//import test.model.User;  
//import test.service.IUserService;  
//  
//@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) //设置要加载的配置文件 
//public class TestMyBatis {  
//    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//    @Resource  
//    private IUserService userService = null;  
//  
//    @Test  
//    public void test1() {  
//        User user = userService.getUserById(1);  
//        // System.out.println(user.getUserName());  
//        // logger.info("值："+user.getUserName());  
//        logger.info(JSON.toJSONString(user));  
//    }  
//}  