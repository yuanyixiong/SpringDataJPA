package online.qsx.repository;

import org.springframework.data.repository.CrudRepository;

import online.qsx.model.NewsModel;

public interface NewsCrudRepository extends CrudRepository<NewsModel, Long> {

}
