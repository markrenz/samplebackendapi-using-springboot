package _class;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Model {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

	@Column(name="created_by")
    public String createdBy;

	@Column(name="user_id")
	public int userId;
}
