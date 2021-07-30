package apis.source.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="customer")
public class Customer implements Serializable{
	
	@Id
	@Column(name="CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@Column(name="MARITAL_STATUS")
	private Integer maritalStatusId;
	
	@Transient
	private String maritalStatus;
	
	@Column(name="SSN_NUMBER")
	private Integer ssnNumber;
	
	@Column(name="HOME_PHONE")
	private String homePhone;
	
	@Column(name="OFFICE_PHONE")
	private String officePhone;
	
	@Column(name="MOBILE")
	private String Mobile;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name="ADDRESS_ID")
	private String addressId;
	
	@Transient
	private Address address;
	
	@Column(name="EMPLOYER_NAME")
	private String employerName;
	
	@Column(name="ANNUAL_SALARY")
	private Integer annualSalary;
	
	@Column(name="WORK_EXP_JOIN_MONTH")
	private Integer workExpJoinMonth;
	
	@Column(name="WORK_EXP_YEARS")
	private Integer workExpJoinYear;
	
	@Column(name="WORK_EXP_JOIN_YEAR")
	private Integer workExpYears;
	
	@Column(name="WORK_EXP_MONTHS")
	private Integer workExpMonths;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="EMPLOYMENT_ADDRESS_ID")
	private String employmentAddressId;
	
	@Transient
	private Address employmentAddress;
	
	public Integer getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(Integer ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getEmploymentAddress() {
		return employmentAddress;
	}
	public void setEmploymentAddress(Address employmentAddress) {
		this.employmentAddress = employmentAddress;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}
	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public Integer getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(Integer annualSalary) {
		this.annualSalary = annualSalary;
	}
	public Integer getWorkExpJoinMonth() {
		return workExpJoinMonth;
	}
	public void setWorkExpJoinMonth(Integer workExpJoinMonth) {
		this.workExpJoinMonth = workExpJoinMonth;
	}
	public Integer getWorkExpJoinYear() {
		return workExpJoinYear;
	}
	public void setWorkExpJoinYear(Integer workExpJoinYear) {
		this.workExpJoinYear = workExpJoinYear;
	}
	public Integer getWorkExpYears() {
		return workExpYears;
	}
	public void setWorkExpYears(Integer workExpYears) {
		this.workExpYears = workExpYears;
	}
	public Integer getWorkExpMonths() {
		return workExpMonths;
	}
	public void setWorkExpMonths(Integer workExpMonths) {
		this.workExpMonths = workExpMonths;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmploymentAddressId() {
		return employmentAddressId;
	}
	public void setEmploymentAddressId(String employmentAddressId) {
		this.employmentAddressId = employmentAddressId;
	}
	
	
}
