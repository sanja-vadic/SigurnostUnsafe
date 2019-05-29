package net.etfbl.sanja.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.etfbl.sanja.dao.UserDAO;
import net.etfbl.sanja.db.DBManager;
import net.etfbl.sanja.dto.User;

public class UserMySql implements UserDAO {
	
	@Override
	public User checkCredentials(String username, String password) throws Exception {
		String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		//try {
			conn = DBManager.getConnection();
			
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.password(rs.getString("password"))
						.firstname(rs.getString("firstname"))
						.lastname(rs.getString("lastname"))
						.build();
			}
			rs.close();
			ps.close();
			conn.close();
		//} catch (Exception e) {
			//e.printStackTrace();
		//}
		
		return user;
	}

	@Override
	public boolean insert(User user) {
		String query = "INSERT INTO users (firstname, lastname, username, password, age) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isOk = false;
		
		try {
			conn = DBManager.getConnection();
			
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getAge());
			ps.execute();
			isOk = true;

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		}
		
		return isOk;
	}

}
