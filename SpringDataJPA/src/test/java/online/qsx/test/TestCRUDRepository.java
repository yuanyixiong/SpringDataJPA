package online.qsx.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.dao.UserCRUDRepository;
import online.qsx.model.User;

public class TestCRUDRepository {

	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// ��ȡָ���Ľӿ�
	UserCRUDRepository userCRUDRepository = ac.getBean(UserCRUDRepository.class);

	public void save() {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 30; i++) {
			list.add(new User("����" + i, i, new Date()));
		}
		userCRUDRepository.save(list);
		System.out.println(list.toString());
	}
	
	public static void main(String[] args) {
		new TestCRUDRepository().save();
	}
}
