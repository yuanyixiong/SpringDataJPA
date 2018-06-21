package online.qsx.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import online.qsx.model.NewsModel;
import online.qsx.repository.NewsPagingAndSortingRepository;

public class TestPagingAndSortingRepository {
	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// 读取指定的接口

	NewsPagingAndSortingRepository newsPagingAndSortingRepository = ac.getBean(NewsPagingAndSortingRepository.class);

	/**
	 * 分页浏览用户信息，并且根据新闻发布的时间降序
	 * 分页要求每页显示3条新闻信息，浏览第2页的新闻信息
	 */
	public void findAll() {
		Order orders = new Order(Direction.DESC, "createDate");// 指定排序列
		Sort sort = new Sort(orders);// 实现排序
		PageRequest pageRequest = new PageRequest(2, 3, sort);// 实现分页
		Page<NewsModel> page = newsPagingAndSortingRepository.findAll(pageRequest);// 查询

		System.out.println("总记录数:" + page.getTotalElements());
		System.out.println("总页数:" + page.getTotalPages());
		System.out.println("当前页（request):" + page.getNumber());
		System.out.println("当前页总记录数（request):" + page.getSize());
		System.out.println("当前页记录总数：" + page.getNumberOfElements());
		List<NewsModel> students = page.getContent();
		for (NewsModel newsModel : students) {
			System.out.println(newsModel);
		}
	}
	
	public static void main(String[] args) {
		new TestPagingAndSortingRepository().findAll();
	}

}
