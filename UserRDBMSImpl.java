package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nucleus.connection.Connectionclass;
import com.nucleus.entity.User;

public class UserRDBMSImpl  implements IUserDao{
	Connectionclass connectionclass = new Connectionclass();
	Connection con = connectionclass.getDBConnection();

	@Override
	public User checkmakerlogindetails(User user) throws SQLException {
 //int flag =0;
		String flag ="";
		PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckeruserlogin where userid=?");
		preparedstmt.setString(1, user.getUserId());
		ResultSet resultset = preparedstmt.executeQuery();
		while(resultset.next())
		{
			//flag =1;
			flag = resultset.getString(4);
			//System.out.println(resultset.getString(1)+" "+resultset.getString(2)+" "+resultset.getString(3));
			System.out.println("Successfully Login");
		}
		user.setFlag(flag);
		return user ;
		
	}

	@Override
	public void insertcheckermakerlogindetails(User user) throws SQLException {
		PreparedStatement preparedstmt = con.prepareStatement("insert into makercheckeruserlogin (userid,password,role) value(?,?,?)");
		preparedstmt.setString(1,user.getUserId());
		preparedstmt.setString(2,user.getPassword());
		preparedstmt.setString(3, user.getRole());
		
		preparedstmt.executeUpdate();
		System.out.println("Record Inserted");
	}

	@Override
	public void updatedetails(User user) throws SQLException {
		PreparedStatement psmt = con.prepareStatement("Update makercheckeruserlogin set flag = ? where userid =?");
		psmt.setString(1, "Active");
		psmt.setString(2, user.getUserId());
		int n = psmt.executeUpdate();
		if(n!=0)
		{
			System.out.println("Record Updated");
		}
		
	}

	@Override
	public void logoutdetails(String userid) throws SQLException {
		PreparedStatement psmt = con.prepareStatement("Update makercheckeruserlogin set flag = ? where userid =?");
		psmt.setString(1, null);
		psmt.setString(2, userid);
		int n = psmt.executeUpdate();
		if(n!=0)
		{
			System.out.println("Logout Updated");
		}
		
	}

	
}