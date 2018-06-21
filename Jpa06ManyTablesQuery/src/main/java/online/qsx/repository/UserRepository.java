package online.qsx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import online.qsx.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>,JpaSpecificationExecutor<UserModel> {

}
