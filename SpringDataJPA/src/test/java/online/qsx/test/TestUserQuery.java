package online.qsx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.dao.UserQuery;

public class TestUserQuery {
	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// 读取指定的接口
	UserQuery userQuery = ac.getBean(UserQuery.class);

	public void test1() {
		System.out.println(userQuery.findUserByMaxId());
	}

	public void test2() {
		System.out.println(userQuery.findUserByParam("张三10", 10));
	}

	public void test3() {
		System.out.println(userQuery.findUserByParam("张三10"));
	}

	public void test4() {
		System.out.println(userQuery.findUserByParam(20, 10));
	}

	public void test5() {
		userQuery.update("李四", 12);
	}
}
