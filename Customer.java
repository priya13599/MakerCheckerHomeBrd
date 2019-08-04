package com.nucleus.entity;

import java.util.Date;

public class Customer {

	
	private String customercode;
	private String customername;
	private String address1;
	private String address2;
	private int customerpincode;
	private String emailaddress;
	private long contactno;
	private String primary_contact_person;
	private String record_status;
	private String active_inactive_flag;
	Date create_date;
	private String created_by;
	Date modified_date;
	private String modified_by;
	Date authorized_date;
	private String authorized_by;
	
	
	
	
	
	public Customer() {
		
	}


	public Customer(String customercode, String customername, String address1, String address2, int customerpincode,
			String emailaddress, long contactno, String primary_contact_person, String record_status,
			String active_inactive_flag, Date create_date, String created_by, Date modified_date, String modified_by,
			Date authorized_date, String authorized_by) {
		
		this.customercode = customercode;
		this.customername = customername;
		this.address1 = address1;
		this.address2 = address2;
		this.customerpincode = customerpincode;
		this.emailaddress = emailaddress;
		this.contactno = contactno;
		this.primary_contact_person = primary_contact_person;
		this.record_status = record_status;
		this.active_inactive_flag = active_inactive_flag;
		this.create_date = create_date;
		this.created_by = created_by;
		this.modified_date = modified_date;
		this.modified_by = modified_by;
		this.authorized_date = authorized_date;
		this.authorized_by = authorized_by;
	}
	
	
	public String getCustomercode() {
		return customercode;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getCustomerpincode() {
		return customerpincode;
	}
	public void setCustomerpincode(int customerpincode) {
		this.customerpincode = customerpincode;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	public String getPrimary_contact_person() {
		return primary_contact_person;
	}
	public void setPrimary_contact_person(String primary_contact_person) {
		this.primary_contact_person = primary_contact_person;
	}
	public String getRecord_status() {
		return record_status;
	}
	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}
	public String getActive_inactive_flag() {
		return active_inactive_flag;
	}
	public void setActive_inactive_flag(String active_inactive_flag) {
		this.active_inactive_flag = active_inactive_flag;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Date getAuthorized_date() {
		return authorized_date;
	}
	public void setAuthorized_date(Date authorized_date) {
		this.authorized_date = authorized_date;
	}
	public String getAuthorized_by() {
		return authorized_by;
	}
	public void setAuthorized_by(String authorized_by) {
		this.authorized_by = authorized_by;
	}
}
