package online.qsx.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;

import online.qsx.model.OrderModel;
import online.qsx.model.UserModel;
import online.qsx.repository.UserRepository;


public class TestRepository {
	// ����spring data jpa �����ļ�
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-jpa.xml");

	// ��ȡָ���Ľӿ�
	UserRepository userRepository = ac.getBean(UserRepository.class);

	// Specification
	// public abstract Predicate toPredicate(Root root, CriteriaQuery query,
	// CriteriaBuilder cb);
	// CriteriaQuery<?> query ��ѯ
	// Root<UserModel> root ������������
	// CriteriaBuilder cb ���������Ĺ���

	/**
	 * ������̬��ѯ
	 * 
	 * @param userModel
	 * @return
	 */
	public List<UserModel> findUser(UserModel userModel) {

		return userRepository.findAll((root, query, cb) -> {

			// ��̬�����ļ���
			List<Predicate> predicates = new ArrayList<Predicate>();

			// ��̬��������
			if (userModel.getLoginName() != null) {
				Predicate predicate = cb.like(root.get("loginName"), "%" + userModel.getLoginName() + "%");
				predicates.add(predicate);
			}
			if (userModel.getPassword() != null) {
				Predicate predicate = cb.equal(root.get("password"), userModel.getPassword());
				predicates.add(predicate);
			}
			if (userModel.getId() != null) {
				Predicate predicate = cb.equal(root.get("id"), userModel.getId());
				predicates.add(predicate);
			}

			// ���ò�ѯ������
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			return null;
		});

	}

	/**
	 * ����Ķ�̬��ѯ
	 * 
	 * @param userModel
	 * @return
	 */
	public List<UserModel> findUserAndOrder(UserModel userModel) {

		return userRepository.findAll((root, query, cb) -> {

			// ��̬�����ļ���
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			// ����
			// JoinType.INNER inner join
			// JoinType.LEFT left join
			// JoinType.RIGHT right join
			Join<Object, Object> join = root.join("orders", JoinType.INNER);

			// ��̬��������
			// UserModel
			if (userModel.getLoginName() != null) {
				Predicate predicate = cb.like(root.get("loginName"), "%" + userModel.getLoginName() + "%");
				predicates.add(predicate);
			}
			if (userModel.getPassword() != null) {
				Predicate predicate = cb.equal(root.get("password"), userModel.getPassword());
				predicates.add(predicate);
			}
			// OrderModel
			if (userModel.getOrders() != null && new ArrayList<OrderModel>(userModel.getOrders()).get(0) != null&& new ArrayList<OrderModel>(userModel.getOrders()).get(0).getCode() != null) {
				Predicate predicate = cb.like(join.get("code"),
						"%" + new ArrayList<OrderModel>(userModel.getOrders()).get(0).getCode() + "%");
				predicates.add(predicate);
			}

			// ���ò�ѯ������
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			return null;
		});

	}

	/**
	 * ��ҳ����Ķ�̬��ѯ,���ݷ�ҳ
	 * 
	 * @param userModel
	 * @return
	 */
	public List<UserModel> findUserAndOrderPageOrder(UserModel userModel) {

		// ����
		Sort sort = new Sort(new ArrayList<Order>() {
			{
				add(new Order(Direction.DESC, "createDate"));// ָ��������
			}
		});

		// ��ҳ
		Pageable pageable = new PageRequest(0, 10, sort);

		// ������ѯ
		Page<UserModel> page = userRepository.findAll((root, query, cb) -> {

			// ��̬�����ļ���
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			// ����
			// JoinType.INNER inner join
			// JoinType.LEFT left join
			// JoinType.RIGHT right join
			Join<Object, Object> join = root.join("orders", JoinType.INNER);

			// ��̬��������
			// UserModel
			if (userModel.getLoginName() != null) {
				Predicate predicate = cb.like(root.get("loginName"), "%" + userModel.getLoginName() + "%");
				predicates.add(predicate);
			}
			if (userModel.getPassword() != null) {
				Predicate predicate = cb.equal(root.get("password"), userModel.getPassword());
				predicates.add(predicate);
			}
			// OrderModel
			if (userModel.getOrders() != null && new ArrayList<OrderModel>(userModel.getOrders()).get(0) != null&& new ArrayList<OrderModel>(userModel.getOrders()).get(0).getCode() != null) {
				Predicate predicate = cb.like(join.get("code"),
						"%" + new ArrayList<OrderModel>(userModel.getOrders()).get(0).getCode() + "%");
				predicates.add(predicate);
			}

			// ���ò�ѯ������
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			return null;

		}, pageable);

		// ��ҳ��Ϣ
		System.out.println("�ܼ�¼��:" + page.getTotalElements());
		System.out.println("��ҳ��:" + page.getTotalPages());
		System.out.println("��ǰҳ��request):" + page.getNumber());
		System.out.println("��ǰҳ�ܼ�¼����request):" + page.getSize());
		System.out.println("��ǰҳ��¼������" + page.getNumberOfElements());
		return page.getContent();

	}

	public static void main(String[] args) {
		UserModel userModel = new UserModel("admin", null, null);
		userModel.getOrders().add(new OrderModel("as", null));

		List<UserModel> list = new TestRepository().findUserAndOrderPageOrder(userModel);

		for (UserModel temp : list) {
			System.out.println(temp.toStringAndOrders());
		}
	}
}
