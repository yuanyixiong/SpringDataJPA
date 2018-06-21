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
	// 加载spring data jpa 配置文件
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-jpa.xml");

	// 读取指定的接口
	UserRepository userRepository = ac.getBean(UserRepository.class);

	// Specification
	// public abstract Predicate toPredicate(Root root, CriteriaQuery query,
	// CriteriaBuilder cb);
	// CriteriaQuery<?> query 查询
	// Root<UserModel> root 条件对象主体
	// CriteriaBuilder cb 构建条件的工具

	/**
	 * 基础动态查询
	 * 
	 * @param userModel
	 * @return
	 */
	public List<UserModel> findUser(UserModel userModel) {

		return userRepository.findAll((root, query, cb) -> {

			// 动态条件的集合
			List<Predicate> predicates = new ArrayList<Predicate>();

			// 动态构建条件
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

			// 设置查询的条件
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			return null;
		});

	}

	/**
	 * 连表的动态查询
	 * 
	 * @param userModel
	 * @return
	 */
	public List<UserModel> findUserAndOrder(UserModel userModel) {

		return userRepository.findAll((root, query, cb) -> {

			// 动态条件的集合
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			// 连表
			// JoinType.INNER inner join
			// JoinType.LEFT left join
			// JoinType.RIGHT right join
			Join<Object, Object> join = root.join("orders", JoinType.INNER);

			// 动态构建条件
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

			// 设置查询的条件
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			return null;
		});

	}

	/**
	 * 分页连表的动态查询,数据分页
	 * 
	 * @param userModel
	 * @return
	 */
	public List<UserModel> findUserAndOrderPageOrder(UserModel userModel) {

		// 排序
		Sort sort = new Sort(new ArrayList<Order>() {
			{
				add(new Order(Direction.DESC, "createDate"));// 指定排序列
			}
		});

		// 分页
		Pageable pageable = new PageRequest(0, 10, sort);

		// 条件查询
		Page<UserModel> page = userRepository.findAll((root, query, cb) -> {

			// 动态条件的集合
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			// 连表
			// JoinType.INNER inner join
			// JoinType.LEFT left join
			// JoinType.RIGHT right join
			Join<Object, Object> join = root.join("orders", JoinType.INNER);

			// 动态构建条件
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

			// 设置查询的条件
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			return null;

		}, pageable);

		// 分页信息
		System.out.println("总记录数:" + page.getTotalElements());
		System.out.println("总页数:" + page.getTotalPages());
		System.out.println("当前页（request):" + page.getNumber());
		System.out.println("当前页总记录数（request):" + page.getSize());
		System.out.println("当前页记录总数：" + page.getNumberOfElements());
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
