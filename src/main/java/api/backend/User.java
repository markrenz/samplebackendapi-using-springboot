package api.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import _class.Model;


@Entity(name = "pfc_tbl_user")
public class User extends Model {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String username;
    private String password;
    private String email;
    @Column(name="created_by")
    public String createdBy;

    public User() {}
    
    public User(String username, String password, String email) {
    	this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        this.createdBy = "1";
    }
    
    public User(Integer id, String username, String password) {
    	this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
    }

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private void setId(Integer id) {
		this.id = id;
	}
	
	private void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	 
	 public String getPassword() {
		 return password;
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	 
	@Override
    public String toString() {
        return "{User:{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                "}";
    }
}
