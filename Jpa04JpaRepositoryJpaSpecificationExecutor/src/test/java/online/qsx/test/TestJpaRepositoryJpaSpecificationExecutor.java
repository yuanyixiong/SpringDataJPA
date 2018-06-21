package online.qsx.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import online.qsx.model.NewsModel;
import online.qsx.repository.NewsJpaRepositoryJpaSpecificationExecutor;

public class TestJpaRepositoryJpaSpecificationExecutor {
	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// 读取指定的接口

	NewsJpaRepositoryJpaSpecificationExecutor newsJpaRepositoryJpaSpecificationExecutor = ac.getBean(NewsJpaRepositoryJpaSpecificationExecutor.class);

	/**
	 * 查询标题中包含”遵义”的新闻，并且根据新闻的发表时间升序
	 * 分页要求每页显示2条新闻信息，浏览第2页的新闻信息
	 */
	public void findAll() {

		Page<NewsModel> page =newsJpaRepositoryJpaSpecificationExecutor.findAll((root, query, cb) -> {
			// 添加条件
			List<Predicate> param = new ArrayList<Predicate>();
			param.add(cb.like(root.get("title").as(String.class), "%遵义%"));

			// 查询添加排序
			query.orderBy(cb.desc(root.get("createDate")), cb.desc(root.get("createDate")));

			// 转换成JPA的条件对象
			Predicate[] predicates = new Predicate[param.size()];
			predicates = param.toArray(predicates);
			return cb.and(predicates);
		},new PageRequest(2, 2));
		
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
		new TestJpaRepositoryJpaSpecificationExecutor().findAll();
	}

}
