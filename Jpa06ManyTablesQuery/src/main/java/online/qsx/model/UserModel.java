package online.qsx.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户
 */
@Entity
@Table(name = "tb_user")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// 账号
	private String loginName;

	// 密码
	private String password;

	// 用户创建时间
	@Temporal(TemporalType.DATE)
	private Date createDate;

	// 特殊属性一个用户拥有多个订单
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<OrderModel> orders = new HashSet<OrderModel>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<OrderModel> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderModel> orders) {
		this.orders = orders;
	}

	public UserModel(String loginName, String password, Date createDate) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.createDate = createDate;
	}

	public UserModel() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", createDate=" + createDate
				+ "]";
	}

	public String toStringAndOrders() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", createDate=" + createDate
				+ ",orders=" + orders + "]";
	}

}