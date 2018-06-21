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
	
	// a) ʹ��@Query����JPQL��ѯ�������߰�����a����������Ϣ���Ҹ��ݷ���ʱ�併��
	@Query(value="from NewsModel where author like ?1 order by createDate desc")
	public List<NewsModel> findListByAuthor(String author);

	// b) ʹ��@Query����SQL��ѯ����ʱ����2017��10��1��-2017��10��31��֮�������,�����ݷ�����������
	@Query(nativeQuery=true,value="select * from tb_news where createDate > ?1 and createDate < ?2 order by createDate asc")
	public List<NewsModel> findListByCreateDates(Date beginDate, Date endDate);

	// c) ʹ��@Query����JPQL�޸ı��Ϊ1�����ţ����ű���ĳ�"������������ǧ��һ���Ķ�ë��ѩ"
	@Transactional //����
	@Modifying //��ɾ����Ҫ
	@Query(value="update NewsModel set title=:title where id=:id") 
	public void edit(@Param("title")String title,@Param("id")Long id);

}
