package online.qsx.test;

import java.util.Date;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.qsx.model.NewsModel;
import online.qsx.repository.NewsCrudRepository;

public class TestCrudRepository {
	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// ��ȡָ���Ľӿ�

	NewsCrudRepository newsCrudRepository = ac.getBean(NewsCrudRepository.class);

	/**
	 * ����,save����save�����ݲ�����ID���Ǳ���
	 */
	public void save() {
		newsCrudRepository.save(new NewsModel("�����¶�ë��ѩ��", "enal", "xxxx", "xxxx", new Date(), new Date()));
	}

	/**
	 * �޸�,save����save�����ݴ���ID�����޸�
	 */
	public void edit() {
		newsCrudRepository.save(new NewsModel(6L,"�����¶�ë��ѩ��", "enal", "xxxx", "xxxx", new Date(), new Date()));
	}

	/**
	 * ����IDɾ��
	 */
	public void remove() {
		newsCrudRepository.delete(new NewsModel(7L));
	}

	/**
	 * �鿴�б�
	 */
	public void findAll() {
		Iterable<NewsModel> collection = newsCrudRepository.findAll();
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			NewsModel newsModel = (NewsModel) iterator.next();
			System.out.println(newsModel);
		}
	}

	/**
	 * ����ID�鿴һ��
	 */
	public void findOne() {
		NewsModel newsModel=newsCrudRepository.findOne(1L);
		System.out.println(newsModel);
	}
	
	public static void main(String[] args) {
		new TestCrudRepository().findAll();
	}
}
