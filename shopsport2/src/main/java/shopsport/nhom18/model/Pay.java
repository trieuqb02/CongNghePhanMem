package shopsport.nhom18.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HINHTHUCTHANHTOAN")
public class Pay {
	@Id
	@Column(name = "MATHANHTOAN", length = 10)
	private String id;
	
	@Column(name = "KIEUTHANHTOAN", length = 100)
	private String typePay;
	
	@OneToOne(mappedBy = "pay")
	private Order oder;
	
	public Pay() {
		super();
	}

	public Pay(String id, String typePay, Order oder) {
		super();
		this.id = id;
		this.typePay = typePay;
		this.oder = oder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypePay() {
		return typePay;
	}

	public void setTypePay(String typePay) {
		this.typePay = typePay;
	}

	public Order getOder() {
		return oder;
	}

	public void setOder(Order oder) {
		this.oder = oder;
	}
	
	
}
