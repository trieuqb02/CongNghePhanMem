package shopsport.nhom18.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailsProductPk implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "MAGIOHANG")
	private Long cart;
	
	@Column(name = "MASANPHAM")
	private String product;
	
	public DetailsProductPk() {
		super();
	}

	public DetailsProductPk(Long cart, String product) {
		super();
		this.cart = cart;
		this.product = product;
	}

	public Long getCart() {
		return cart;
	}

	public void setCart(Long cart) {
		this.cart = cart;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cart, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsProductPk other = (DetailsProductPk) obj;
		return Objects.equals(cart, other.cart) && Objects.equals(product, other.product);
	}
	
	
}
