package online.qsx.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	 * ʹ��@Query����JPQL��ѯ�������߰�����a����������Ϣ���Ҹ��ݷ���ʱ�併��
	 */
	public void findListByAuthor() {
		List<NewsModel> list = newsRepository.findListByAuthor("%a%");
		for (NewsModel newsModel : list) {
			System.out.println(newsModel);
		}
	}

	/**
	 * ʹ��@Query����SQL��ѯ����ʱ����2017��10��1��-2017��10��31��֮�������,�����ݷ�����������
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
	 * ʹ��@Query����JPQL�޸ı��Ϊ1�����ţ����ű���ĳ�""
	 */
	public void edit() {
		newsRepository.edit("������������ǧ��һ���Ķ�ë��ѩ", 1L);
	}

	public static void main(String[] args) throws ParseException {
		new TestRepository().findListByCreateDates();
	}

}
