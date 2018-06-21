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
	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// ��ȡָ���Ľӿ�

	NewsPagingAndSortingRepository newsPagingAndSortingRepository = ac.getBean(NewsPagingAndSortingRepository.class);

	/**
	 * ��ҳ����û���Ϣ�����Ҹ������ŷ�����ʱ�併��
	 * ��ҳҪ��ÿҳ��ʾ3��������Ϣ�������2ҳ��������Ϣ
	 */
	public void findAll() {
		Order orders = new Order(Direction.DESC, "createDate");// ָ��������
		Sort sort = new Sort(orders);// ʵ������
		PageRequest pageRequest = new PageRequest(2, 3, sort);// ʵ�ַ�ҳ
		Page<NewsModel> page = newsPagingAndSortingRepository.findAll(pageRequest);// ��ѯ

		System.out.println("�ܼ�¼��:" + page.getTotalElements());
		System.out.println("��ҳ��:" + page.getTotalPages());
		System.out.println("��ǰҳ��request):" + page.getNumber());
		System.out.println("��ǰҳ�ܼ�¼����request):" + page.getSize());
		System.out.println("��ǰҳ��¼������" + page.getNumberOfElements());
		List<NewsModel> students = page.getContent();
		for (NewsModel newsModel : students) {
			System.out.println(newsModel);
		}
	}
	
	public static void main(String[] args) {
		new TestPagingAndSortingRepository().findAll();
	}

}
