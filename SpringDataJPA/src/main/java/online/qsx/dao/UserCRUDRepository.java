package online.qsx.dao;

import org.springframework.data.repository.CrudRepository;

import online.qsx.model.User;

//2 拥有了增删改查的基本功能
public interface UserCRUDRepository extends CrudRepository<User, Integer> {

}
