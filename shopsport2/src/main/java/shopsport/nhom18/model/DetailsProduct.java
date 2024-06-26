package shopsport.nhom18.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETGIOHANG")
public class DetailsProduct {
	@EmbeddedId
	private DetailsProductPk id;
	
	@Column(name = "SOLUONG")
	private int quantity;
	
//	@Column(name = "TONGGIA")
//	private double sumPrice;
	
	@ManyToOne
	@MapsId("product")
	@JoinColumn(name = "MASANPHAM")
	private Product product;
	
	@ManyToOne
	@MapsId("cart")
	@JoinColumn(name = "MAGIOHANG")
	private Cart cart;

	
	public DetailsProduct() {
		super();
	}
	
	

	public DetailsProduct(DetailsProductPk id, int quantity, Product product, Cart cart) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.cart = cart;
	}



	public DetailsProduct(DetailsProductPk id, int quantity, double sumPrice) {
		super();
		this.id = id;
		this.quantity = quantity;
//		this.sumPrice = sumPrice;
	}

	public DetailsProductPk getId() {
		return id;
	}

	public void setId(DetailsProductPk id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public double getSumPrice() {
//		return sumPrice;
//	}
//
//	public void setSumPrice(double sumPrice) {
//		this.sumPrice = sumPrice;
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
