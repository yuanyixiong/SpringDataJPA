package online.qsx.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import online.qsx.model.User;

//4 ӵ������ɾ�Ĳ��ҳ������Ļ����������ˢ�»���
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
