package online.qsx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.dao.UserJpaRepository;

public class TestJpaRepository {

	// ����spring data jpa �����ļ�
	ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// ��ȡָ���Ľӿ�
	UserJpaRepository userJpaRepository = ac.getBean(UserJpaRepository.class);

	public void test() {
		System.out.println(userJpaRepository.findOne(15));
		System.out.println(userJpaRepository.exists(15));
	}

}
