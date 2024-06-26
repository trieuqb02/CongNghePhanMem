package shopsport.nhom18.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETPHIEUNHAP")
public class DetailsReceipt {
	@EmbeddedId
	private DetailsReceiptPK id;
	
	@Column(name = "SOLUONG")
	private int quantity;
	
	@Column(name = "DONGIANHAP")
	private double priceImport;
	
	@ManyToOne
    @MapsId("receipt")
    @JoinColumn(name = "MAPHIEUNHAP")
	private Receipt receipt;

    @ManyToOne
    @MapsId("product")
    @JoinColumn(name = "MASANPHAM")
    private Product product;

	public DetailsReceipt() {
		super();
	}

	public DetailsReceipt(int quantity, double priceImport, Receipt receipt, Product product) {
		super();
		this.quantity = quantity;
		this.priceImport = priceImport;
		this.receipt = receipt;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public double getPriceImport() {
		return priceImport;
	}

	public void setPriceImport(double priceImport) {
		this.priceImport = priceImport;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DetailsReceiptPK getId() {
		return id;
	}

	public void setId(DetailsReceiptPK id) {
		this.id = id;
	}
	
}
