package online.qsx.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import online.qsx.dao.UserJpaSpecificationExecutor;
import online.qsx.model.User;

public class TestJpaSpecificationExecutor {

	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// ��ȡָ���Ľӿ�
	UserJpaSpecificationExecutor userJpaSpecificationExecutor = ac.getBean(UserJpaSpecificationExecutor.class);

	/**
	 * ��ҳ ���� ������
	 */
	public void testPageingAndSorting() {
		// ����
		Order order = new Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		// ��ҳ
		Pageable pageable = new PageRequest(0, 10, sort);
		// ����
		Specification<User> specification = new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path age = root.get("age");
				Path name = root.get("nam	e");
				return cb.and(cb.lt(age, 10), cb.like(name, "%9%"));
			}
		};
		// ��ѯ
		Page<User> page = userJpaSpecificationExecutor.findAll(specification, pageable);
		System.out.println("��ҳ����" + page.getTotalPages());
		System.out.println("������������" + page.getTotalElements());
		System.out.println("��ǰ��ҳ��:" + page.getNumber() + 1);
		System.out.println("��ǰҳ����������" + page.getNumberOfElements());
		System.out.println("��ǰҳ������:" + page.getContent());

		System.out.println("ok");
	}
}
