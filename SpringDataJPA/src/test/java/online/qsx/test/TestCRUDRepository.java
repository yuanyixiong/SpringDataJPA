package online.qsx.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.dao.UserCRUDRepository;
import online.qsx.model.User;

public class TestCRUDRepository {

	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// 读取指定的接口
	UserCRUDRepository userCRUDRepository = ac.getBean(UserCRUDRepository.class);

	public void save() {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 30; i++) {
			list.add(new User("张三" + i, i, new Date()));
		}
		userCRUDRepository.save(list);
		System.out.println(list.toString());
	}
	
	public static void main(String[] args) {
		new TestCRUDRepository().save();
	}
}
