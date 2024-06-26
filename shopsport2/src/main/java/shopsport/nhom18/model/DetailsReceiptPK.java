package shopsport.nhom18.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailsReceiptPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "MAPHIEUNHAP")
    private String receipt;

    @Column(name = "MASANPHAM")
    private String product;
    
	public DetailsReceiptPK() {
		super();
	}

	public DetailsReceiptPK(String receipt, String product) {
		super();
		this.receipt = receipt;
		this.product = product;
	}

	public DetailsReceiptPK(String product) {
		super();
		this.product = product;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(product, receipt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsReceiptPK other = (DetailsReceiptPK) obj;
		if (receipt != other.receipt)
			return false;
		if (product != other.product)
			return false;
		return true;
	}

}
