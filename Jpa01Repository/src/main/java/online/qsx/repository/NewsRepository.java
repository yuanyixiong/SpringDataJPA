package online.qsx.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.Repository;

import online.qsx.model.NewsModel;

public interface NewsRepository extends Repository<NewsModel, Long> {

	/**
	 * ��ѯ���ű����а��������塱�������б�
	 * @param title
	 * @return
	 */
	public List<NewsModel> findByTitleLike(String title);

	/**
	 * ��ѯ�ա���ı༭��2017��10��10�ŵ�2017��10��15��֮�䷢������ţ����������ŷ���ʱ�併��
	 * @param title
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<NewsModel> findByTitleLikeAndCreateDateGreaterThanAndCreateDateLessThanOrderByCreateDateDesc(String title,Date beginDate,Date endDate);

}
