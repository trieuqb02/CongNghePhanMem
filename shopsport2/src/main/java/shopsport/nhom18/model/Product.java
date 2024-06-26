package shopsport.nhom18.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SANPHAM")
public class Product {
	@Id
	@Column(name = "MASANPHAM", length =10)
	private String id;
	
	@Column(name = "TENSANPHAM", length =100)
	private String name;
	
	@Column(name = "MOTA", length =5000)
	private String description;
	
	@Column(name = "GIA")
	private double price;
	
	@Column(name = "HINHANH", length =500)
	private String image;
	
	@Column(name = "SOLUONGTON")
	private int quantity = 0;
	
	
	@Column(name = "TRANGTHAISANPHAM")
	private boolean status = false;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "MADANHMUC")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<DetailsReceipt> detailsReceipts;
	
	@OneToMany(mappedBy = "product")
	private List<DetailsOder> detailsOders;

	public Product() {
		super();
	}
	
	public Product(String id) {
		super();
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<DetailsReceipt> getDetailsReceipts() {
		return detailsReceipts;
	}

	public void setDetailsReceipts(List<DetailsReceipt> detailsReceipts) {
		this.detailsReceipts = detailsReceipts;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<DetailsOder> getDetailsOders() {
		return detailsOders;
	}

	public void setDetailsOders(List<DetailsOder> detailsOders) {
		this.detailsOders = detailsOders;
	}
	
}
