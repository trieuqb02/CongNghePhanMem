package shopsport.nhom18.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHUCVU")
public class Role {
	@Id
    @Column(name = "MACHUCVU", length = 10)
	private String id;
	
	@Column(name = "TENCHUCVU", length = 50)
    private String name;
    
//    @ManyToMany(mappedBy = "roles")
//    private List<Account> users;
	
	@OneToMany(mappedBy = "role")
    private List<Account> accounts;
    
	public Role(String name) {
		super();
		this.name = name;
	}
	public Role(String id, String name, List<Account> users) {
		super();
		this.id = id;
		this.name = name;
//		this.users = users;
	}
	public Role() {
		super();
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
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
//	public List<Account> getUsers() {
//		return users;
//	}
//	public void setUsers(List<Account> users) {
//		this.users = users;
//	}
    
	
}
