package online.qsx.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import online.qsx.model.NewsModel;

public interface NewsPagingAndSortingRepository extends PagingAndSortingRepository<NewsModel, Long> {

}
