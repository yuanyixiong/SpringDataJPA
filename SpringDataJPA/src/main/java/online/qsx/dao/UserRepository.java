package online.qsx.dao;

import org.springframework.data.repository.Repository;

import online.qsx.model.User;

//1 自定义方法要符合SpringData JPA 的要求才能运行, 方法名对应SQl语句
//继承Repository接口或者使用RepositoryDefinition是一样的效果
//@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
//public interface UserRepository {
public interface UserRepository extends Repository<User, Integer> {
	
	public User findByNameLike(String name);

}
