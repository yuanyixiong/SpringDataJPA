package online.qsx.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import online.qsx.model.User;


//3 拥有了增删改查的基本功能,外加分页和排序
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Integer> {

}
