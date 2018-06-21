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

	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// 读取指定的接口
	UserJpaSpecificationExecutor userJpaSpecificationExecutor = ac.getBean(UserJpaSpecificationExecutor.class);

	/**
	 * 分页 排序 带条件
	 */
	public void testPageingAndSorting() {
		// 排序
		Order order = new Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		// 分页
		Pageable pageable = new PageRequest(0, 10, sort);
		// 条件
		Specification<User> specification = new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path age = root.get("age");
				Path name = root.get("nam	e");
				return cb.and(cb.lt(age, 10), cb.like(name, "%9%"));
			}
		};
		// 查询
		Page<User> page = userJpaSpecificationExecutor.findAll(specification, pageable);
		System.out.println("总页数：" + page.getTotalPages());
		System.out.println("总数据条数：" + page.getTotalElements());
		System.out.println("当前的页数:" + page.getNumber() + 1);
		System.out.println("当前页数据条数：" + page.getNumberOfElements());
		System.out.println("当前页的数据:" + page.getContent());

		System.out.println("ok");
	}
}
