package online.qsx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import online.qsx.model.User;

//5 ӵ����ɾ�Ĳ��ҳ������չ�˴�����
public interface UserJpaSpecificationExecutor extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

}
