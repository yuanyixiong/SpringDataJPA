package online.qsx.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import online.qsx.model.User;

//4 拥有了增删改查分页和排序的基本功能外加刷新缓存
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
