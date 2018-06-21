package online.qsx.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import online.qsx.model.NewsModel;

public interface NewsRepository extends Repository<NewsModel, Long> {
	
	// a) 使用@Query定义JPQL查询新闻作者包含“a”的新闻信息并且根据发表时间降序
	@Query(value="from NewsModel where author like ?1 order by createDate desc")
	public List<NewsModel> findListByAuthor(String author);

	// b) 使用@Query定义SQL查询发表时间在2017年10月1日-2017年10月31日之间的新闻,并根据发表日期升序
	@Query(nativeQuery=true,value="select * from tb_news where createDate > ?1 and createDate < ?2 order by createDate asc")
	public List<NewsModel> findListByCreateDates(Date beginDate, Date endDate);

	// c) 使用@Query定义JPQL修改编号为1的新闻，新闻标题改成"贵州遵义下起千年一遇的鹅毛大雪"
	@Transactional //事物
	@Modifying //增删改需要
	@Query(value="update NewsModel set title=:title where id=:id") 
	public void edit(@Param("title")String title,@Param("id")Long id);

}
