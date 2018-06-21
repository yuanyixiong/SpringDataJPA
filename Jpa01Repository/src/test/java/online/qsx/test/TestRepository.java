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
	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// ��ȡָ���Ľӿ�

	NewsRepository newsRepository = ac.getBean(NewsRepository.class);

	/**
	 * ��ѯ���ű����а��������塱�������б�
	 */
	public void findByTitle() {
		List<NewsModel> list = newsRepository.findByTitleLike("%����%");
		for (NewsModel newsModel : list) {
			System.out.println(newsModel);
		}
	}

	/**
	 * ��ѯ�ա���ı༭��2017��10��10�ŵ�2017��10��15��֮�䷢������ţ����������ŷ���ʱ�併��
	 */
	public void findByTitleAndCreateDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = sdf.parse("2017-10-10");
		Date endDate = sdf.parse("2017-10-15");
		List<NewsModel> list = newsRepository.findByTitleLikeAndCreateDateGreaterThanAndCreateDateLessThanOrderByCreateDateDesc("%����%", beginDate,endDate);
		for (NewsModel newsModel : list) {
			System.out.println(newsModel);
		}
	}

	public static void main(String[] args) throws ParseException {
		new TestRepository().findByTitle();
	}

}
