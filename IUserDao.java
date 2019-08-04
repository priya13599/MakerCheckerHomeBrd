package com.nucleus.dao;

import java.sql.SQLException;

import com.nucleus.entity.User;

public interface IUserDao {
	
	public User checkmakerlogindetails(User user) throws SQLException;
	public void updatedetails(User user) throws SQLException;
	public void logoutdetails(String userid) throws SQLException;
	public void insertcheckermakerlogindetails(User user) throws SQLException;
	

}
