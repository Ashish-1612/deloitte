package com.example.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UserInfo;

@Repository
public class LibraryDao {

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

	public ArrayList<UserInfo> showAllUser() {

		try {
			ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
			Connection con = connectToDB();
			// step 3 create the statement
			PreparedStatement stmt = con.prepareStatement("select * from personaldetail");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserInfo user1 = new UserInfo();
				user1.setUserId(rs.getInt(1));
				user1.setEmail(rs.getString(2));
				user1.setName(rs.getString(3));
				user1.setFatherName(rs.getString(4));
				user1.setMotherName(rs.getString(5));
				user1.setAddress(rs.getString(6));
				user1.setContactNo(rs.getLong(7));
				user1.setGender(rs.getString(8));
				user1.setPassword(rs.getString(9));
				userList.add(user1);
			}
			// step 4 execute sql command
			// step5 close connection
			con.close();
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void addUser(UserInfo user) {

		try {
			Connection con = connectToDB();
			PreparedStatement stmt = con.prepareStatement("select Idseq.NEXTVAL from dual");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			stmt = con.prepareStatement("insert into personaldetail values(?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getFatherName());
			stmt.setString(5, user.getMotherName());
			stmt.setString(6, user.getAddress());
			stmt.setLong(7, user.getContactNo());
			stmt.setString(8, user.getGender());
			stmt.setString(9, user.getPassword());
			// step 4 execute sql command
			int affectedRow = stmt.executeUpdate();
			System.out.println(affectedRow);
			// step5 close connection
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public UserInfo displayUser(int userId) {

		try {

			Connection con = connectToDB();
			// step 3 create the statement
			PreparedStatement stmt = con.prepareStatement("select * from personaldetail where userId=?");
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			UserInfo user1 = new UserInfo();
			while (rs.next()) {

				user1.setUserId(rs.getInt(1));
				user1.setEmail(rs.getString(2));
				user1.setName(rs.getString(3));
				user1.setFatherName(rs.getString(4));
				user1.setMotherName(rs.getString(5));
				user1.setAddress(rs.getString(6));
				user1.setContactNo(rs.getLong(7));
				user1.setGender(rs.getString(8));
				user1.setPassword(rs.getString(9));
			}
			// step 4 execute sql command
			// step5 close connection
			con.close();
			return user1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String validateUser(int userId, String password) {
		// TODO Auto-generated method stub
		try {

			Connection con = connectToDB();
			// step 3 create the statement
			PreparedStatement stmt = con.prepareStatement("select name from personaldetail where userId=? AND password=?");
			stmt.setInt(1, userId);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
		    String message=null;
			while(rs.next()) {
              message=rs.getString(1);
			}
			// step 4 execute sql command
			// step5 close connection
			con.close();
		return message;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
