package online.qsx.dao;

import org.springframework.data.repository.CrudRepository;

import online.qsx.model.User;

//2 ӵ������ɾ�Ĳ�Ļ�������
public interface UserCRUDRepository extends CrudRepository<User, Integer> {

}
