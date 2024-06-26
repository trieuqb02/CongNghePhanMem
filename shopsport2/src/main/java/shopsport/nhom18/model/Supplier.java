package shopsport.nhom18.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="NHACUNGCAP")
public class Supplier {
	@Id
	@Column(name ="MANHACUNGCAP", length = 10)
	private String id;
	
	@Column(name = "TENNHACUNGCAP", length = 50)
	private String name;
	
	@Column(name = "SDT", length = 11)
	private String phone;
	
	@Column(name = "DIACHI", length = 500)
	private String address;
	
	@Column(name = "TRANGTHAIDANHMUC")
    private boolean status = false;
	
	@OneToMany(mappedBy = "supplier")
	private List<Receipt> receipts;

	public Supplier() {
		super();
	}
	
	public Supplier(String id) {
		super();
		this.id = id;
	}

	public Supplier(String id, String name, String phone, String address, List<Receipt> receipts) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.receipts = receipts;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	 
	
	
}
