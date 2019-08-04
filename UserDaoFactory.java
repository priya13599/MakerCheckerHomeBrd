package com.nucleus.dao;

public class UserDaoFactory {
	
	
	public static IUserDao getUserDao()
	{
		return new UserRDBMSImpl();
	}
	public static ICustomerDao getCustomerDao()
	{
		return new CustomerRDBMSImpl();
	}

}
