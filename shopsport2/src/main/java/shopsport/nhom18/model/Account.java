package shopsport.nhom18.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TAIKHOAN")
public class Account {
	
	@Id
	@Column(name = "TENDANGNHAP", length = 50)
	private String username;
	
	@Column(name = "MATKHAU", length = 100)
	private String password;
	
	@Column(name = "TRANGTHAI")
	private boolean status = false;
	
	@Column(name = "EMAIL", length = 1000)
	private String email;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Staff staff;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "MACHUCVU")
	private Role role;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "TAIKHOAN_CHUCVU", joinColumns = @JoinColumn(name = "MATAIKHOAN"), inverseJoinColumns = @JoinColumn(name = "MACHUCVU"))
//	private List<Role> roles;
	
	public Account() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
