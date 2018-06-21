package online.qsx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.dao.UserJpaRepository;

public class TestJpaRepository {

	// 加载spring data jpa 配置文件
	ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// 读取指定的接口
	UserJpaRepository userJpaRepository = ac.getBean(UserJpaRepository.class);

	public void test() {
		System.out.println(userJpaRepository.findOne(15));
		System.out.println(userJpaRepository.exists(15));
	}

}
