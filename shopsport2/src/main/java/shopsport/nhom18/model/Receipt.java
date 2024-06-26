package shopsport.nhom18.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIEUNHAP")
public class Receipt {
	@Id
	@Column(name = "MAPHIEUNHAP",length = 10)
	private String id;
	
	@Column(name = "NGAYLAP")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;
	
	@Column(name="TONGTIEN")
	private double sumMoney;
	
	@ManyToOne
	@JoinColumn(name = "MANHANVIEN")
	private Staff staff;

	@ManyToOne
	@JoinColumn(name = "MANHACUNGCAP")
	private Supplier supplier;
	
	@OneToMany(mappedBy = "receipt")
	private List<DetailsReceipt> detailsReceipts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<DetailsReceipt> getDetailsReceipts() {
		return detailsReceipts;
	}

	public void setDetailsReceipts(List<DetailsReceipt> detailsReceipts) {
		this.detailsReceipts = detailsReceipts;
	}
	
}
