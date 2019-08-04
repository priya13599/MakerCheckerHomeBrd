package com.nucleus.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.nucleus.entity.*;

public class ValidationMethods {

	public boolean CheckCustomerName(String customername)
	{  int flag =0;
	
	   String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
	
	   String str1[] = specialCharacters.split("");
	   String str2[]=customername.split("[ ]+");
	   for(int k =0;k<str2.length;k++)
	   {
	   String str3[] = str2[k].split("");
	   

	    for (int i=0;i<str3.length;i++)
	    {
	    	for(int j=0;j<str1.length;j++)
	    	{
	    if (str1[j].contains(str3[i]))
	    {
	    	flag =1;
	    	break;
	    }
	    
	    }
	    }
	   }
	
		if(flag ==1)
		{
			return true;
		}
		else
		
			return false;
		
	}
	
	// Check pincode which should be equal to length of 6
	public boolean CheckPincode(String pincode)
	{
		int flag =0;
		String str[] = pincode.split("");
		if(str.length!=6)
		{
			flag =1;
		}
		
		if(flag ==1)
		{
			return true;
		}
		else
		
			return false;
		
	}
	
	
	// Check EmailAddress
	public boolean CheckEmailAddress(String email)
	{
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = pattern.matcher(email);
		boolean b = m.find();
		if(b==true)
		{
			return true;
		}
		else
			return false;
	}
	
	//Domain Value Checking
	// Check Record Status : it should be in [N,M,D,A,R]
	public boolean CheckRecordStatus(String status)
	{   boolean b=false;
	if(status==null)
	{
		return true;
	}
		if(status.equals("N")||status.equals("M")||status.equals("D")||status.equals("A")||status.equals("R"))
		{
			b=true;
		}
		
		if(b==true)
		{
			return true;
		}
		else
			return false;
	
	
	}
	
	
	
	// Check Flag : It should be in [A,I]
	public boolean CheckFlag(String flag)
	{ boolean b=false;
		if(flag.equals("A")||flag.equals("I"))
		{
			b=true;
		}
		
		if(b==true)
		{
			return true;
		}
		else
			return false;
	}
	
	//Check Data Length for the data
	public boolean CheckDataLength(String datavalue,int datalength)
	{
		if(datavalue == null)
		{
			return true;
		}
		else
		{
			
		int length = datavalue.length();
		
		if(length <=datalength)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
	}
	
	// Check Mandatory and NonMandatory Fields : its should be not null

public boolean CheckMandatoryFields(String string)
{
	if(string ==null)
	{
		return false;
	}
	else
	{
		return true;
	}
}

// Check DataType for all the records
	public boolean CheckDataType(String string,String datatype)
	{
		int flag =0;
		
		if(string !=null)
		{
			
		
		if(datatype.equals("Number"))
		{
			try
			{
			Integer.parseInt(string);
			flag =1;
			}
			catch(NumberFormatException e)
			{
				flag =0;
				System.out.println("int");
			}
		}
		
		if(datatype.equals("Long"))
		{
			try
			{
			Long.parseLong(string);
			flag =1;
			}
			catch(NumberFormatException e)
			{
				System.out.println("long");
				flag =0;
			}
		}
		if(datatype.equals("Alpha-Numeric"))
		{
		if(string instanceof String)
		{
			flag =1;
		}
		else
		{
			System.out.println("string");
			flag =0;
		}
		}
		if(datatype.equals("Date"))
		{
			try {
				new SimpleDateFormat("dd/MMM/yyyy").parse(string);
				flag =1;
			} catch (ParseException e) {
			
				e.printStackTrace();
				flag =0;
				System.out.println("date");
			}
		}
	}
		else
		{
			flag =1;
		}
		if(flag ==1)
			
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	// Check Primary Key : customercode should be not same in the existing arraylist customercode
	public boolean CheckPrimaryKey(ArrayList<Customer> list, String customercode)
	{
	int flag =0;
	for(int i =0;i<list.size();i++)
	{
		if(customercode.equals(list.get(i).getCustomercode()))
		{
			flag =1;
			break;
		}
		else
		{
			flag =0;
		}
	}
	
	
	if(flag ==1)
		
	{
		return true;
	}
	else
	{
		return false;
	}
	}
	 

}

