package com.deloitte.demo.Dao;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.deloitte.demo.model.LoginInfo;



@Repository
public class DesignationDAO {
	public static Connection connectToDB() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public LoginInfo validateUser(int userId,String password) {
          LoginInfo user = new LoginInfo();
		try {
			
			Connection con = connectToDB();
			// step 3 create the statement
			PreparedStatement stmt = con.prepareStatement("select * from loginInfo where userId=? AND password=?");
			stmt.setInt(1, userId);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setPassword(rs.getString(2));
				user.setUsertype(rs.getString(3));
			}
			// step 4 execute sql command
			// step5 close connection
			con.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
