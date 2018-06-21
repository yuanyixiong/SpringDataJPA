package online.qsx.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	 * 查询新闻标题中包含“遵义”的新闻列表
	 */
	public void findByTitle() {
		List<NewsModel> list = newsRepository.findByTitleLike("%遵义%");
		for (NewsModel newsModel : list) {
			System.out.println(newsModel);
		}
	}

	/**
	 * 查询姓”李”的编辑在2017年10月10号到2017年10月15号之间发表的新闻，并根据新闻发表时间降序
	 */
	public void findByTitleAndCreateDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = sdf.parse("2017-10-10");
		Date endDate = sdf.parse("2017-10-15");
		List<NewsModel> list = newsRepository.findByTitleLikeAndCreateDateGreaterThanAndCreateDateLessThanOrderByCreateDateDesc("%遵义%", beginDate,endDate);
		for (NewsModel newsModel : list) {
			System.out.println(newsModel);
		}
	}

	public static void main(String[] args) throws ParseException {
		new TestRepository().findByTitle();
	}

}
