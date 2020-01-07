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
	public LoginInfo validateUser(LoginInfo user1) {
          
		try {
			
			Connection con = connectToDB();
			System.out.println("dao");
			// step 3 create the statement
			PreparedStatement stmt = con.prepareStatement("select usertype from loginInfo where userId=? AND password=?");
			stmt.setInt(1, user1.getUserId());
			stmt.setString(2, user1.getPassword());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user1.setUsertype(rs.getString(1));
			}
			// step 4 execute sql command
			// step5 close connection
			System.out.println("user "+user1);
			con.close();
			return user1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
