package com.nucleus.validation;

import java.text.SimpleDateFormat;

import com.nucleus.entity.Customer;

public class CheckValidations {

	ValidationMethods validationmethods = new ValidationMethods();
	public boolean DataLength(Customer customer)
    {
  
    boolean g1 = validationmethods.CheckDataLength(customer.getCustomercode(),10);
    boolean g2 = validationmethods.CheckDataLength(customer.getCustomername(),30);
    boolean g3 = validationmethods.CheckDataLength(customer.getAddress1(),100);
    boolean g4= validationmethods.CheckDataLength(customer.getAddress2(),100);
    boolean g5 =validationmethods.CheckDataLength(Integer.toString(customer.getCustomerpincode()),6);
    boolean g6 = validationmethods.CheckDataLength(customer.getEmailaddress(),100);
    boolean g7= validationmethods.CheckDataLength(Long.toString(customer.getContactno()),20);
    boolean g8= validationmethods.CheckDataLength(customer.getPrimary_contact_person(),100); 
    boolean g9= validationmethods.CheckDataLength(customer.getRecord_status(),1);
    boolean g10 = validationmethods.CheckDataLength(customer.getActive_inactive_flag(),1);  
    boolean g11 = validationmethods.CheckDataLength(customer.getCreated_by(),30); 
    boolean g12 = validationmethods.CheckDataLength(customer.getModified_by(),30); 
    boolean g13 = validationmethods.CheckDataLength(customer.getAuthorized_by(),30);
   
    if(g1 ==true&&g2 ==true&&g3 ==true&&g4 ==true&&g5 ==true&&g6 ==true&&g7 ==true&&g8 ==true&&g9 ==true&&g10 ==true&&g11 ==true&&g12 ==true&&g13 ==true)
    {
  	  return true ;
    }
    else
    {
  	  return false;
    }
    
    
    }
	
	
	
	public boolean MandatoryFields(Customer customer)
	{
		boolean h1=validationmethods.CheckMandatoryFields(customer.getCustomercode());
		System.out.println("h1"+h1);
		boolean h2=validationmethods.CheckMandatoryFields(customer.getCustomername());
		System.out.println("h2"+h2);
		boolean h3=validationmethods.CheckMandatoryFields(customer.getAddress1());
		System.out.println("h3"+h3);
		boolean h4=validationmethods.CheckMandatoryFields(Integer.toString(customer.getCustomerpincode()));
		System.out.println("h4"+h4);
		boolean h5=validationmethods.CheckMandatoryFields(customer.getEmailaddress());
		System.out.println("h5"+h5);
		boolean h6=validationmethods.CheckMandatoryFields(customer.getPrimary_contact_person());
		System.out.println("h6"+h6);
		boolean h7=validationmethods.CheckMandatoryFields(customer.getRecord_status());
		System.out.println("h7"+h7);
		boolean h8=validationmethods.CheckMandatoryFields(customer.getActive_inactive_flag());
		System.out.println("h8"+h8);
		boolean h9=validationmethods.CheckMandatoryFields(new SimpleDateFormat("dd/MMM/yyyy").format(customer.getCreate_date()));
		System.out.println("h9"+h9);
		boolean h10=validationmethods.CheckMandatoryFields(customer.getCreated_by());
		System.out.println("h10"+h10);
		
		
		if(h1==true&&h2==true&&h3==true&&h4==true&&h5==true&&h6==true&&h7==true&&h8==true&&h9==true&&h10==true)
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	
	
	public boolean DataType(Customer customer)
	{
		boolean i13=false;
		boolean i15 = false;
		boolean i1 = validationmethods.CheckDataType(customer.getCustomercode(), "Alpha-Numeric");
		boolean i2 = validationmethods.CheckDataType(customer.getCustomername(), "Alpha-Numeric");
		boolean i3 = validationmethods.CheckDataType(customer.getAddress1(), "Alpha-Numeric");
		boolean i4 = validationmethods.CheckDataType(customer.getAddress2(), "Alpha-Numeric");
		boolean i5 = validationmethods.CheckDataType(Integer.toString(customer.getCustomerpincode()), "Number");
		boolean i6 = validationmethods.CheckDataType(customer.getEmailaddress(), "Alpha-Numeric");
		boolean i7 = validationmethods.CheckDataType(Long.toString(customer.getContactno()), "Long");
		boolean i8 = validationmethods.CheckDataType(customer.getPrimary_contact_person(), "Alpha-Numeric");
		boolean i9 = validationmethods.CheckDataType(customer.getRecord_status(), "Alpha-Numeric");
		boolean i10 = validationmethods.CheckDataType(customer.getActive_inactive_flag(), "Alpha-Numeric");
		boolean i11 = validationmethods.CheckDataType(new SimpleDateFormat("dd/MMM/yyyy").format(customer.getCreate_date()), "Date");
		boolean i12 = validationmethods.CheckDataType(customer.getCreated_by(), "Alpha-Numeric");
		if(customer.getModified_date()!=null)
		{
		i13 = validationmethods.CheckDataType(new SimpleDateFormat("dd/MMM/yyyy").format(customer.getModified_date()), "Date");
		}
		else
		{
			i13 = true;
		}
		boolean i14 = validationmethods.CheckDataType(customer.getModified_by(), "Alpha-Numeric");
		if(customer.getAuthorized_date()!= null)
		{
		 i15 = validationmethods.CheckDataType(new SimpleDateFormat("dd/MMM/yyyy").format(customer.getAuthorized_date()), "Date");
		}
		else
		{
			i15 = true;
		}
		boolean i16 = validationmethods.CheckDataType(customer.getAuthorized_by(), "Alpha-Numeric");
		if(i1==true&&i2==true&&i3==true&&i4==true&&i5==true&&i6==true&&i7==true&&i8==true&&i9==true&&i10==true&&i11==true&&i11==true&&i12==true&&i13==true&&i14==true&&i15==true&&i16==true)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
		
	}

}

