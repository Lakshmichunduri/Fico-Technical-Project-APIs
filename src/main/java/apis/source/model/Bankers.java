package apis.source.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Bankers" )
public class Bankers implements Serializable{
	
	@Id
	private int banker_id;
	private String username;
	private String password;
	private String employee_id;
	
	
	public int getBanker_id() {
		return banker_id;
	}
	public void setBanker_id(int banker_id) {
		this.banker_id = banker_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	


}
