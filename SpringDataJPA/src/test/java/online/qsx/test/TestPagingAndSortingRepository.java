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

	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring-data-jpa.xml");
	// 读取指定的接口
	UserPagingAndSortingRepository userPagingAndSortingRepository = ac.getBean(UserPagingAndSortingRepository.class);

	public void testPageing() {
		// 分页
		Pageable pageable = new PageRequest(0, 10);
		// 查询
		Page<User> page = userPagingAndSortingRepository.findAll(pageable);
		System.out.println("总页数：" + page.getTotalPages());
		System.out.println("总数据条数：" + page.getTotalElements());
		System.out.println("当前的页数:" + page.getNumber() + 1);
		System.out.println("当前页数据条数：" + page.getNumberOfElements());
		System.out.println("当前页的数据:" + page.getContent());
	}

	public void testPageingAndSorting() {
		// 排序
		Order order = new Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		// 分页
		Pageable pageable = new PageRequest(0, 10, sort);
		// 查询
		Page<User> page = userPagingAndSortingRepository.findAll(pageable);
		System.out.println("总页数：" + page.getTotalPages());
		System.out.println("总数据条数：" + page.getTotalElements());
		System.out.println("当前的页数:" + page.getNumber() + 1);
		System.out.println("当前页数据条数：" + page.getNumberOfElements());
		System.out.println("当前页的数据:" + page.getContent());
	}

}
