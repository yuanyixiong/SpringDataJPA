package online.qsx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import online.qsx.dao.UserPagingAndSortingRepository;
import online.qsx.model.User;

public class TestPagingAndSortingRepository {

	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// ��ȡָ���Ľӿ�
	UserPagingAndSortingRepository userPagingAndSortingRepository = ac.getBean(UserPagingAndSortingRepository.class);

	public void testPageing() {
		// ��ҳ
		Pageable pageable = new PageRequest(0, 10);
		// ��ѯ
		Page<User> page = userPagingAndSortingRepository.findAll(pageable);
		System.out.println("��ҳ����" + page.getTotalPages());
		System.out.println("������������" + page.getTotalElements());
		System.out.println("��ǰ��ҳ��:" + page.getNumber() + 1);
		System.out.println("��ǰҳ����������" + page.getNumberOfElements());
		System.out.println("��ǰҳ������:" + page.getContent());
	}

	public void testPageingAndSorting() {
		// ����
		Order order = new Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		// ��ҳ
		Pageable pageable = new PageRequest(0, 10, sort);
		// ��ѯ
		Page<User> page = userPagingAndSortingRepository.findAll(pageable);
		System.out.println("��ҳ����" + page.getTotalPages());
		System.out.println("������������" + page.getTotalElements());
		System.out.println("��ǰ��ҳ��:" + page.getNumber() + 1);
		System.out.println("��ǰҳ����������" + page.getNumberOfElements());
		System.out.println("��ǰҳ������:" + page.getContent());
	}

}
