package online.qsx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.dao.UserRepository;

public class TestRepository {

	// ����spring data jpa �����ļ�
	ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// ��ȡָ���Ľӿ�
	UserRepository userRepository = ac.getBean(UserRepository.class);

	public void test() {
		System.out.println(userRepository.findByNameLike("%����%"));
	}

}
