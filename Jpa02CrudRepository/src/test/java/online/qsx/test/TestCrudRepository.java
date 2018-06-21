package online.qsx.test;

import java.util.Date;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.model.NewsModel;
import online.qsx.repository.NewsCrudRepository;

public class TestCrudRepository {
	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// 读取指定的接口

	NewsCrudRepository newsCrudRepository = ac.getBean(NewsCrudRepository.class);

	/**
	 * 保存,save方法save的数据不存在ID就是保存
	 */
	public void save() {
		newsCrudRepository.save(new NewsModel("遵义下鹅毛大雪了", "enal", "xxxx", "xxxx", new Date(), new Date()));
	}

	/**
	 * 修改,save方法save的数据存在ID就是修改
	 */
	public void edit() {
		newsCrudRepository.save(new NewsModel(6L,"遵义下鹅毛大雪了", "enal", "xxxx", "xxxx", new Date(), new Date()));
	}

	/**
	 * 根据ID删除
	 */
	public void remove() {
		newsCrudRepository.delete(new NewsModel(7L));
	}

	/**
	 * 查看列表
	 */
	public void findAll() {
		Iterable<NewsModel> collection = newsCrudRepository.findAll();
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			NewsModel newsModel = (NewsModel) iterator.next();
			System.out.println(newsModel);
		}
	}

	/**
	 * 根据ID查看一个
	 */
	public void findOne() {
		NewsModel newsModel=newsCrudRepository.findOne(1L);
		System.out.println(newsModel);
	}
	
	public static void main(String[] args) {
		new TestCrudRepository().findAll();
	}
}
