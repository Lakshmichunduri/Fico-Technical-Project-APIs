package apis.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.BureauData;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BureauResponse{
	
	private int loan_amnt;
	private int emp_length;
	private int annual_inc;
	private int purpose;
	private int year;
	private int delinq_2yrs;
	private int inq_last_6mths;
	private int mths_since_last_delinq;
	private int mths_since_last_record;
	private int open_acc;
	private int pub_rec;
	private int revol_bal;
	private double revol_util;
	private int total_acc;
	
	public int getLoan_amnt() {
		return loan_amnt;
	}
	public void setLoan_amnt(int loan_amnt) {
		this.loan_amnt = loan_amnt;
	}
	public int getEmp_length() {
		return emp_length;
	}
	public void setEmp_length(int emp_length) {
		this.emp_length = emp_length;
	}
	public int getAnnual_inc() {
		return annual_inc;
	}
	public void setAnnual_inc(int annual_inc) {
		this.annual_inc = annual_inc;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDelinq_2yrs() {
		return delinq_2yrs;
	}
	public void setDelinq_2yrs(int delinq_2yrs) {
		this.delinq_2yrs = delinq_2yrs;
	}
	public int getInq_last_6mths() {
		return inq_last_6mths;
	}
	public void setInq_last_6mths(int inq_last_6mths) {
		this.inq_last_6mths = inq_last_6mths;
	}
	public int getMths_since_last_delinq() {
		return mths_since_last_delinq;
	}
	public void setMths_since_last_delinq(int mths_since_last_delinq) {
		this.mths_since_last_delinq = mths_since_last_delinq;
	}
	public int getMths_since_last_record() {
		return mths_since_last_record;
	}
	public void setMths_since_last_record(int mths_since_last_record) {
		this.mths_since_last_record = mths_since_last_record;
	}
	public int getOpen_acc() {
		return open_acc;
	}
	public void setOpen_acc(int open_acc) {
		this.open_acc = open_acc;
	}
	public int getPub_rec() {
		return pub_rec;
	}
	public void setPub_rec(int pub_rec) {
		this.pub_rec = pub_rec;
	}
	public int getRevol_bal() {
		return revol_bal;
	}
	public void setRevol_bal(int revol_bal) {
		this.revol_bal = revol_bal;
	}
	public double getRevol_util() {
		return revol_util;
	}
	public void setRevol_util(double revol_util) {
		this.revol_util = revol_util;
	}
	public int getTotal_acc() {
		return total_acc;
	}
	public void setTotal_acc(int total_acc) {
		this.total_acc = total_acc;
	}

}
