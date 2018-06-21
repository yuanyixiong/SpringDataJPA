package online.qsx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import online.qsx.model.User;

//5 拥有增删改查分页排序，扩展了带条件
public interface UserJpaSpecificationExecutor extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

}
