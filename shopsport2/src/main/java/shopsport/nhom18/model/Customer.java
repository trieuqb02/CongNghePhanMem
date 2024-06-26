package shopsport.nhom18.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="KHACHHANG")
public class Customer {
	@Id
	@Column(name = "MAKHACHHANG",length = 10)
	private String id;
	
	@Column(name = "HO", length = 25)
	private String surname;
	
	@Column(name = "TEN", length = 25)
	private String name;
	
	@Column(name = "DIACHI", length = 500)
	private String address;
	
	@Column(name = "ANH", length = 1000)
	private String image = "avatar5.png";
	
	@Column(name = "GIOITINH", length = 10)
	private String gender;
	
	@Column(name = "SDT", length = 10)
	private String phone;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATAIKHOAN")
	private Account account;
	
	@OneToMany(mappedBy = "customer")
	private List<Cart> listCart;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> oders;

	public Customer() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Cart> getListCart() {
		return listCart;
	}

	public void setListCart(List<Cart> listCart) {
		this.listCart = listCart;
	}

	public List<Order> getOders() {
		return oders;
	}

	public void setOders(List<Order> oders) {
		this.oders = oders;
	}
	
	
}
