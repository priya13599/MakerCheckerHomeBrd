package com.nucleus.dao;

import java.sql.SQLException;

import com.nucleus.entity.User;

public class UserRDBMSImplService implements IUserService {
	
	IUserDao userdao = UserDaoFactory.getUserDao();
	@Override
	public User checkmakerlogindetails(User user) throws SQLException {
		
		User flag = userdao.checkmakerlogindetails(user);
		return flag;
	}
	@Override
	public void insertcheckermakerlogindetails(User user) throws SQLException {
		userdao.insertcheckermakerlogindetails(user);
		
	}
	@Override
	public void updatedetails(User user) throws SQLException {
		userdao.updatedetails(user);
	}
	@Override
	public void logoutdetails(String userid) throws SQLException {
		userdao.logoutdetails(userid);
		
	}

}
