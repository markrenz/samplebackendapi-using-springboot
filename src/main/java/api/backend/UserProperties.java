package api.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import _class.Model;

@Entity(name = "pfc_tbl_user_info")
public class UserProperties extends Model{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
    private String lastName;
	@Column(name="user_num")
    private int userNum;
	@Column(name="middle_name")
    private String middleName;
	@Column(name="telephone_num")
    private String telephoneNum;
	@Column(name="user_id")
	public int userId;
	@Column(name="created_by")
    public String createdBy;
    
    public UserProperties() {}
    
    public UserProperties(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    
    public UserProperties(Integer userId, String firstName, String lastName, String telephone) {
    	this.setUserId(userId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTelephone(telephone);
        this.userNum = userId;
        this.createdBy = "1";
    }

	public void setTelephone(String telephone) {
		this.telephoneNum = telephone;
	}
	
	public String getTelephoneNum() {
		return telephoneNum;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	 public int getId() {
		 return id;
	 }

	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public int getUserId() {
		 return userId;
	 }

}