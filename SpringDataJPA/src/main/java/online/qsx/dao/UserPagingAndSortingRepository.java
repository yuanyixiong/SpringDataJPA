package online.qsx.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import online.qsx.model.User;


//3 ӵ������ɾ�Ĳ�Ļ�������,��ӷ�ҳ������
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Integer> {

}
