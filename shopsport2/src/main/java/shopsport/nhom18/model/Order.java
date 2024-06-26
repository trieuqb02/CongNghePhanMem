package shopsport.nhom18.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIEUDAT")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAPHIEUDAT")
	private Long id;
	
	@Column(name = "NGAYLAP")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name = "SODIENTHOAIKHACHHANG", length = 11)
	private String phone;
	
	@Column(name = "GHICHU", length = 5000)
	private String note;
	
	@Column(name = "DIACHI", length = 500)
	private String address;
	
	@OneToOne
	@JoinColumn(name = "MATHANHTOAN")
	private Pay pay;
	
	@ManyToOne
	@JoinColumn(name = "MAKHACHHANG")
	private Customer customer;
	
	@Column(name = "TRANGTHAI", length = 5000)
	private String status;
	
	@Column(name = "NGAYCAPNHAT")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;
	
	@ManyToOne
	@JoinColumn(name = "MANHANVIEN")
	private Staff staff;
	
	@OneToMany(mappedBy = "oder",fetch = FetchType.EAGER)
	private List<DetailsOder> detailsOders;
	
	
	public Order() {
		super();
	}

	public Order(Long id, Date date, String phone, String note, String address) {
		super();
		this.id = id;
		this.date = date;
		this.phone = phone;
		this.note = note;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<DetailsOder> getDetailsOders() {
		return detailsOders;
	}

	public void setDetailsOders(List<DetailsOder> detailsOders) {
		this.detailsOders = detailsOders;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	
	
}
