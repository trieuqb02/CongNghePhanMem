package shopsport.nhom18.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NHANVIEN")
public class Staff {
	@Id
	@Column(name = "MANHANVIEN", length = 10)
	private String id;

	@Column(name = "HO", length = 50)
	private String surname;

	@Column(name = "TEN", length = 50)
	private String name;

	@Column(name = "CMND", length = 12)
	private String cmnd;

	@Column(name = "ANH", length = 500)
	private String image = "avatar5.png";

	@Column(name = "GIOITINH", length = 10)
	private String gender;

	@Column(name = "DIACHI", length = 500)
	private String address;

	@Column(name = "SDT", length = 10)
	private String phone;

	@Column(name = "NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATAIKHOAN")
	private Account account;
	
	@OneToMany(mappedBy = "staff")
	private List<Receipt> receipts;
	
	@OneToMany(mappedBy = "staff")
	private List<Order> oders;
	

	public Staff() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}

	public List<Order> getOders() {
		return oders;
	}

	public void setOders(List<Order> oders) {
		this.oders = oders;
	}
	
	
	
}
