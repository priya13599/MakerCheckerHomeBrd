package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.nucleus.connection.Connectionclass;
import com.nucleus.entity.Customer;

public class CustomerRDBMSImpl implements ICustomerDao{
	Connectionclass connectionclass = new Connectionclass(); //Object of Connectionclass
	Connection con = connectionclass.getDBConnection();   // Calling a getDBConnection method of Connectionclass

	@Override
	public void SaveCustomerDetails(Customer customer) throws SQLException {
		
		PreparedStatement preparedstmt = con.prepareStatement("insert into makercheckercustomertable130 (customer_code,customer_name,customer_address1,customer_address2,customer_pin_code,email_address,contact_number ,primary_contact_person,record_status,active_inactive_flag,create_date,created_by,modified_date, modified_by,authorized_date,authorized_by) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedstmt.setString(1,customer.getCustomercode());
		preparedstmt.setString(2, customer.getCustomername());
		preparedstmt.setString(3, customer.getAddress1());
		preparedstmt.setString(4, customer.getAddress2());
		preparedstmt.setInt(5, customer.getCustomerpincode());
		preparedstmt.setString(6, customer.getEmailaddress());
		preparedstmt.setLong(7, customer.getContactno());
		preparedstmt.setString(8, customer.getPrimary_contact_person());
		preparedstmt.setString(9, customer.getRecord_status());
		preparedstmt.setString(10, customer.getActive_inactive_flag());
		System.out.println("ksddjdksj");
		java.util.Date date = customer.getCreate_date();
		if(date!=null)
		{
		java.sql.Date dt = new java.sql.Date(date.getTime());   // Util date converted into sql date
		preparedstmt.setDate(11, dt);
		}
		else
		{
			preparedstmt.setDate(11,(Date) date);     //this allows JDBC to identify this is a sql date
		}
	
		preparedstmt.setString(12, customer.getCreated_by());
		
		java.util.Date date2 = customer.getModified_date();
		if(date2!=null)
		{
		java.sql.Date dt1 = new java.sql.Date(date2.getTime());
		preparedstmt.setDate(13, dt1);
		}
		else
		{
			preparedstmt.setDate(13,(Date) date2);
		}
		
				preparedstmt.setString(14, customer.getModified_by());
				
				java.util.Date date3 = customer.getAuthorized_date();
				if(date3!=null)
				{
				java.sql.Date dt2 = new java.sql.Date(date3.getTime());
				preparedstmt.setDate(15, dt2);
				}
				else
				{
					preparedstmt.setDate(15,(Date) date3);
				}
			
				preparedstmt.setString(16, customer.getAuthorized_by());
				
				preparedstmt.executeUpdate();
				System.out.println("------ Record Inserted In Database -------");
				//connectionclass.closeDBConnection();

				
				}

	@Override
	public void DeleteCustomerDetails(Customer customer) throws SQLException {

		PreparedStatement preparedstmt = con.prepareStatement("delete from makercheckercustomertable130 where customer_code =?");
				preparedstmt.setString(1,customer.getCustomercode());
				preparedstmt.executeUpdate();
				System.out.println("Record Deleted");
		
	}

	@Override
	public Customer updatecustomerDetails(String customercode) throws SQLException {
		PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckercustomertable130 where customer_code =?");
		preparedstmt.setString(1,customercode);
		ResultSet resultset = preparedstmt.executeQuery();
		Customer customer = new Customer();
		while(resultset.next())
		{
			
			customer.setCustomercode(resultset.getString(1));
			customer.setCustomername(resultset.getString(2));
			customer.setAddress1(resultset.getString(3));
			customer.setAddress2(resultset.getString(4));
			customer.setCustomerpincode(Integer.parseInt(resultset.getString(5)));
			customer.setEmailaddress(resultset.getString(6));
			customer.setContactno(Long.parseLong(resultset.getString(7)));
			customer.setPrimary_contact_person(resultset.getString(8));
			customer.setRecord_status(resultset.getString(9));
			customer.setActive_inactive_flag(resultset.getString(10));
			customer.setCreate_date(resultset.getDate(11));
			customer.setCreated_by(resultset.getString(12));
			customer.setAuthorized_date(resultset.getDate(15));
			customer.setAuthorized_by(resultset.getString(16));
			
		}
		return customer;
	}

	@Override
	public void updatecustomerDetails1(Customer customer) throws SQLException {
		PreparedStatement preparedstmt = con.prepareStatement("Update makercheckercustomertable130 set customer_name=?,customer_address1=?,customer_address2=?,customer_pin_code=?,email_address=?,contact_number=?,record_status=?,primary_contact_person=?,active_inactive_flag=?,create_date=?,created_by=?,modified_date=?, modified_by=?,authorized_date=?,authorized_by=? where customer_code =?");
		preparedstmt.setString(1,customer.getCustomername());
		System.out.println(customer.getCustomername());
		preparedstmt.setString(2,customer.getAddress1());
		preparedstmt.setString(3, customer.getAddress2());
		preparedstmt.setInt(4, customer.getCustomerpincode());
		preparedstmt.setString(5,customer.getEmailaddress());
		preparedstmt.setLong(6, customer.getContactno());
		preparedstmt.setString(7, customer.getRecord_status());
		preparedstmt.setString(8, customer.getPrimary_contact_person());
		
		preparedstmt.setString(9,customer.getActive_inactive_flag());
		
		java.util.Date date = customer.getCreate_date();
		if(date!=null)
		{
		java.sql.Date dt = new java.sql.Date(date.getTime());   // Util date converted into sql date
		preparedstmt.setDate(10, dt);
		}
		else
		{
			preparedstmt.setDate(10,(Date) date);     //this allows JDBC to identify this is a sql date
		}
	
		preparedstmt.setString(11, customer.getCreated_by());
		
		
		java.util.Date date2 = customer.getModified_date();
		if(date2!=null)
		{
		java.sql.Date dt1 = new java.sql.Date(date2.getTime());
		preparedstmt.setDate(12, dt1);
		}
		else
		{
			preparedstmt.setDate(12,(Date) date2);
		}
	    preparedstmt.setString(13, customer.getModified_by());
	   
		
		java.util.Date date3 = customer.getAuthorized_date();
		if(date3!=null)
		{
		java.sql.Date dt2 = new java.sql.Date(date3.getTime());
		preparedstmt.setDate(14, dt2);
		}
		else
		{
			preparedstmt.setDate(14,(Date) date3);
		}
	
		preparedstmt.setString(15, customer.getAuthorized_by());
		preparedstmt.setString(16,customer.getCustomercode());
		preparedstmt.executeUpdate();
		System.out.println("Record Updated");
		
	}

	@Override
	public ArrayList DisplayCustomerDetails() throws SQLException {
		ArrayList<Customer> arraylist = new ArrayList<Customer>();
		
		PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckercustomertable130");
		
		ResultSet resultset = preparedstmt.executeQuery();
		Customer[] customer = new Customer[1000];
		while(resultset.next())
		{
			int i=0;
			customer[i] = new Customer();
			customer[i].setCustomercode(resultset.getString(1));
			customer[i].setCustomername(resultset.getString(2));
			customer[i].setAddress1(resultset.getString(3));
			customer[i].setAddress2(resultset.getString(4));
			customer[i].setCustomerpincode(Integer.parseInt(resultset.getString(5)));
			customer[i].setEmailaddress(resultset.getString(6));
			customer[i].setContactno(Long.parseLong(resultset.getString(7)));
			customer[i].setPrimary_contact_person(resultset.getString(8));
			customer[i].setRecord_status(resultset.getString(9));
			customer[i].setActive_inactive_flag(resultset.getString(10));
			customer[i].setCreate_date(resultset.getDate(11));
			customer[i].setCreated_by(resultset.getString(12));
			customer[i].setAuthorized_date(resultset.getDate(15));
			customer[i].setAuthorized_by(resultset.getString(16));
			arraylist.add(customer[i]);
			i++;
			
			
		}
		
		return arraylist;
		
	}

	@Override
	public Customer DispalyCustomerDetailsByCode(String customercode) throws SQLException {
		
		
        PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckercustomertable130 where customer_code =?");
		preparedstmt.setString(1,customercode);
		ResultSet resultset = preparedstmt.executeQuery();
		
		Customer customer = new Customer();
		while(resultset.next())
		{
			
			customer.setCustomercode(resultset.getString(1));
			customer.setCustomername(resultset.getString(2));
			customer.setAddress1(resultset.getString(3));
			customer.setAddress2(resultset.getString(4));
			customer.setCustomerpincode(Integer.parseInt(resultset.getString(5)));
			customer.setEmailaddress(resultset.getString(6));
			customer.setContactno(Long.parseLong(resultset.getString(7)));
			customer.setPrimary_contact_person(resultset.getString(8));
			customer.setRecord_status(resultset.getString(9));
			customer.setActive_inactive_flag(resultset.getString(10));
			customer.setCreate_date(resultset.getDate(11));
			customer.setCreated_by(resultset.getString(12));
			customer.setModified_date(resultset.getDate(13));
			customer.setModified_by(resultset.getString(14));
			customer.setAuthorized_date(resultset.getDate(15));
			customer.setAuthorized_by(resultset.getString(16));
			
		}
		return customer;
		
	}

	@Override
	public ArrayList SortAscendingCustomerDetails() throws SQLException {
ArrayList<Customer> arraylist = new ArrayList<Customer>();
		
		PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckercustomertable130 order by customer_code asc");
		
		ResultSet resultset = preparedstmt.executeQuery();
		Customer[] customer = new Customer[1000];
		while(resultset.next())
		{
			int i=0;
			customer[i] = new Customer();
			customer[i].setCustomercode(resultset.getString(1));
			customer[i].setCustomername(resultset.getString(2));
			customer[i].setAddress1(resultset.getString(3));
			customer[i].setAddress2(resultset.getString(4));
			customer[i].setCustomerpincode(Integer.parseInt(resultset.getString(5)));
			customer[i].setEmailaddress(resultset.getString(6));
			customer[i].setContactno(Long.parseLong(resultset.getString(7)));
			customer[i].setPrimary_contact_person(resultset.getString(8));
			customer[i].setRecord_status(resultset.getString(9));
			customer[i].setActive_inactive_flag(resultset.getString(10));
			customer[i].setCreate_date(resultset.getDate(11));
			customer[i].setCreated_by(resultset.getString(12));
			customer[i].setAuthorized_date(resultset.getDate(15));
			customer[i].setAuthorized_by(resultset.getString(16));
			arraylist.add(customer[i]);
			i++;
			
			
		}
		
		return arraylist;
	}

	@Override
	public ArrayList SortDescendingCustomerDetails() throws SQLException {
ArrayList<Customer> arraylist = new ArrayList<Customer>();
		
		PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckercustomertable130 order by customer_code desc");
		
		ResultSet resultset = preparedstmt.executeQuery();
		Customer[] customer = new Customer[1000];
		while(resultset.next())
		{
			int i=0;
			customer[i] = new Customer();
			customer[i].setCustomercode(resultset.getString(1));
			customer[i].setCustomername(resultset.getString(2));
			customer[i].setAddress1(resultset.getString(3));
			customer[i].setAddress2(resultset.getString(4));
			customer[i].setCustomerpincode(Integer.parseInt(resultset.getString(5)));
			customer[i].setEmailaddress(resultset.getString(6));
			customer[i].setContactno(Long.parseLong(resultset.getString(7)));
			customer[i].setPrimary_contact_person(resultset.getString(8));
			customer[i].setRecord_status(resultset.getString(9));
			customer[i].setActive_inactive_flag(resultset.getString(10));
			customer[i].setCreate_date(resultset.getDate(11));
			customer[i].setCreated_by(resultset.getString(12));
			customer[i].setAuthorized_date(resultset.getDate(15));
			customer[i].setAuthorized_by(resultset.getString(16));
			arraylist.add(customer[i]);
			i++;
			
			
		}
		
		return arraylist;
	}

	@Override
	public ArrayList CheckPrimaryKey() throws SQLException {
ArrayList<Customer> arraylist = new ArrayList<Customer>();
		
		PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckercustomertable130");
		
		ResultSet resultset = preparedstmt.executeQuery();
		Customer[] customer = new Customer[1000];
		while(resultset.next())
		{
			int i=0;
			customer[i] = new Customer();
			customer[i].setCustomercode(resultset.getString(1));
			arraylist.add(customer[i]);
			i++;
			
			
		}
		
		return arraylist;
	}
				
	}
	



		


