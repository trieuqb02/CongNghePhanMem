package shopsport.nhom18.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailsOderPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "MADONHANG")
	private Long oder;
	
	@Column(name = "MASANPHAM",length = 10)
	private String product;

	
	
	public DetailsOderPk(Long oder, String product) {
		super();
		this.oder = oder;
		this.product = product;
	}

	public DetailsOderPk() {
		super();
	}

	public Long getOder() {
		return oder;
	}

	public void setOder(Long oder) {
		this.oder = oder;
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
		return Objects.hash(oder, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsOderPk other = (DetailsOderPk) obj;
		return Objects.equals(oder, other.oder) && Objects.equals(product, other.product);
	}
	
	

}
