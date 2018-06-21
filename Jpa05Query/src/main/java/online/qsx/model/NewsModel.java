package online.qsx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_news")
public class NewsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String author;

	private String introduction;

	private String content;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Temporal(TemporalType.DATE)
	private Date modifyDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "NewsModel [id=" + id + ", title=" + title + ", author=" + author + ", introduction=" + introduction
				+ ", content=" + content + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

	public NewsModel(Long id, String title, String author, String introduction, String content, Date createDate,
			Date modifyDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.introduction = introduction;
		this.content = content;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public NewsModel(String title, String author, String introduction, String content, Date createDate,
			Date modifyDate) {
		super();
		this.title = title;
		this.author = author;
		this.introduction = introduction;
		this.content = content;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public NewsModel(Long id) {
		super();
		this.id = id;
	}

	public NewsModel() {
		super();
	}

}
