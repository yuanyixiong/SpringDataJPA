package online.qsx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import online.qsx.model.User;

//6 自定义Sql的方式操作数据库
public interface UserQuery extends Repository<User,Integer>{

	/**
	 * 直接查询--类似Hql
	 * @return
	 */
	@Query(value="from User o where o.id =( select max(t1.id) from User t1)")
	public User findUserByMaxId();
	
	/**
	 * 占位符查询--类似Hql
	 * @param name
	 * @param age
	 * @return
	 */
	@Query(value="from User o where o.age=?2 and o.name like ?1 ")
	public List<User> findUserByParam(String name,Integer age);
	
	/**
	 * 命名查询--类似Hql
	 * @param name
	 * @return
	 */
	@Query(value="from User o where  o.name like :a ")
	public List<User> findUserByParam(@Param("a") String name);
	
	
	/**
	 * 占位符查询--原声SQl
	 * @param min_age
	 * @param max_age
	 * @return
	 */
	@Query(nativeQuery=true,value="select * from tb_user u where u.age<?1 and u.age>?2")
	public List<User> findUserByParam(Integer max_age,Integer min_age);
	
	/**
	 * 增删改的方法
	 * @param name
	 * @param id
	 */
	@Transactional //事物
	@Modifying //增删改需要
	@Query(value="update User set name=:name where id=:id") //sql or 类hql 语句
	public void update(@Param("name")String name,@Param("id")Integer id);

}
