package online.qsx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import online.qsx.model.NewsModel;

public interface NewsJpaRepositoryJpaSpecificationExecutor extends JpaRepository<NewsModel, Long>,JpaSpecificationExecutor<NewsModel> {

}
