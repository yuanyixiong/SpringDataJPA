package online.qsx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.dao.UserRepository;

public class TestRepository {

	// 加载spring data jpa 配置文件
	ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// 读取指定的接口
	UserRepository userRepository = ac.getBean(UserRepository.class);

	public void test() {
		System.out.println(userRepository.findByNameLike("%张三%"));
	}

}
