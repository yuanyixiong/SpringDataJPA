package online.qsx.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.model.NewsModel;
import online.qsx.repository.NewsRepository;

public class TestRepository {
	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// 读取指定的接口

	NewsRepository newsRepository = ac.getBean(NewsRepository.class);

	/**
	 * 使用@Query定义JPQL查询新闻作者包含“a”的新闻信息并且根据发表时间降序
	 */
	public void findListByAuthor() {
		List<NewsModel> list = newsRepository.findListByAuthor("%a%");
		for (NewsModel newsModel : list) {
			System.out.println(newsModel);
		}
	}

	/**
	 * 使用@Query定义SQL查询发表时间在2017年10月1日-2017年10月31日之间的新闻,并根据发表日期升序
	 * 
	 * @throws ParseException
	 */
	public void findListByCreateDates() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<NewsModel> list = newsRepository.findListByCreateDates(sdf.parse("2017-10-01"), sdf.parse("2017-10-31"));
		for (NewsModel newsModel : list) {
			System.out.println(newsModel);
		}
	}

	/**
	 * 使用@Query定义JPQL修改编号为1的新闻，新闻标题改成""
	 */
	public void edit() {
		newsRepository.edit("贵州遵义下起千年一遇的鹅毛大雪", 1L);
	}

	public static void main(String[] args) throws ParseException {
		new TestRepository().findListByCreateDates();
	}

}
