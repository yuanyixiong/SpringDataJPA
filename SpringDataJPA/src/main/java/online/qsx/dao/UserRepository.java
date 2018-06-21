package online.qsx.dao;

import org.springframework.data.repository.Repository;

import online.qsx.model.User;

//1 �Զ��巽��Ҫ����SpringData JPA ��Ҫ���������, ��������ӦSQl���
//�̳�Repository�ӿڻ���ʹ��RepositoryDefinition��һ����Ч��
//@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
//public interface UserRepository {
public interface UserRepository extends Repository<User, Integer> {
	
	public User findByNameLike(String name);

}
