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
	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml","classpath:applicationContext-jpa.xml");
	// ��ȡָ���Ľӿ�

	NewsJpaRepositoryJpaSpecificationExecutor newsJpaRepositoryJpaSpecificationExecutor = ac.getBean(NewsJpaRepositoryJpaSpecificationExecutor.class);

	/**
	 * ��ѯ�����а��������塱�����ţ����Ҹ������ŵķ���ʱ������
	 * ��ҳҪ��ÿҳ��ʾ2��������Ϣ�������2ҳ��������Ϣ
	 */
	public void findAll() {

		Page<NewsModel> page =newsJpaRepositoryJpaSpecificationExecutor.findAll((root, query, cb) -> {
			// �������
			List<Predicate> param = new ArrayList<Predicate>();
			param.add(cb.like(root.get("title").as(String.class), "%����%"));

			// ��ѯ�������
			query.orderBy(cb.desc(root.get("createDate")), cb.desc(root.get("createDate")));

			// ת����JPA����������
			Predicate[] predicates = new Predicate[param.size()];
			predicates = param.toArray(predicates);
			return cb.and(predicates);
		},new PageRequest(2, 2));
		
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
		new TestJpaRepositoryJpaSpecificationExecutor().findAll();
	}

}
