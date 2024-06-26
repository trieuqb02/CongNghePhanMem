package shopsport.nhom18.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETPHIEUDAT")
public class DetailsOder {
	@EmbeddedId
	private DetailsOderPk id;
	
	@Column(name = "SOLUONG")
	private int quantity;
	
	@Column(name = "GIA")
	private double price;
	
	@ManyToOne
	@MapsId("product")
	@JoinColumn(name = "MASANPHAM")
	private Product product;
	
	@ManyToOne
	@MapsId("oder")
	@JoinColumn(name = "MADONHANG")
	private Order oder;

	public DetailsOder() {
		super();
	}
	
	
	public DetailsOderPk getId() {
		return id;
	}

	public void setId(DetailsOderPk id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOder() {
		return oder;
	}

	public void setOder(Order oder) {
		this.oder = oder;
	}
	
	
}
