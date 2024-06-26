package shopsport.nhom18.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="DANHMUC")
public class Category {
	@Id
	@Column(name = "MADANHMUC", length = 10)
	private String id;
	
	@Column(name = "TENDANHMUC", length = 50)
	private String name;
	
	@Column(name = "TRANGTHAiDANHMUC")
	private boolean status= false;
	
	@OneToMany(mappedBy = "category")
	private List<Product> listProdcut;

	public Category() {
		super();
	}

	public Category(String id) {
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

	public List<Product> getListProdcut() {
		return listProdcut;
	}

	public void setListProdcut(List<Product> listProdcut) {
		this.listProdcut = listProdcut;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
