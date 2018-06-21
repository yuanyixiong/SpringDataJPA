package online.qsx.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.Repository;

import online.qsx.model.NewsModel;

public interface NewsRepository extends Repository<NewsModel, Long> {

	/**
	 * 查询新闻标题中包含“遵义”的新闻列表
	 * @param title
	 * @return
	 */
	public List<NewsModel> findByTitleLike(String title);

	/**
	 * 查询姓”李”的编辑在2017年10月10号到2017年10月15号之间发表的新闻，并根据新闻发表时间降序
	 * @param title
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<NewsModel> findByTitleLikeAndCreateDateGreaterThanAndCreateDateLessThanOrderByCreateDateDesc(String title,Date beginDate,Date endDate);

}
