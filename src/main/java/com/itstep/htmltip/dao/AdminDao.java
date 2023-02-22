package com.itstep.htmltip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itstep.htmltip.entity.Admin;
import com.itstep.htmltip.utils.ConnectionUtil;

public class AdminDao {
	public static int save(Admin admin) {
		Connection connect = ConnectionUtil.getConnection();
		int status = 0;
		if (connect != null) {
			String sql = "INSERT INTO tbl_admin(username, password) VALUES(?, ?)";
			PreparedStatement statement;
			try {
				statement = connect.prepareStatement(sql);
				statement.setString(1, admin.getUsername());
				statement.setString(2, admin.getPassword());
				
				status = statement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return status;
	}
	
	public static Admin auth(Admin admin) {
		Connection connect = ConnectionUtil.getConnection();
		Admin found = null;
		if (connect != null) {
			String sql = "SELECT * FROM tbl_admin WHERE username=? AND password=?";
			PreparedStatement statement;
			
			try {
				statement = connect.prepareStatement(sql);
				statement.setString(1, admin.getUsername());
				statement.setString(2, admin.getPassword());
				
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					found = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return found;
	}
	
	public static boolean adminExist() {
		Connection connect = ConnectionUtil.getConnection();
		Admin found = null;
		if (connect != null) {
			String sql = "SELECT * FROM tbl_admin";
			PreparedStatement statement;
			
			try {
				statement = connect.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					found = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return found != null;
	}

	public static List<Admin> getAll() {
		Connection connect = ConnectionUtil.getConnection();
		List<Admin> users = new ArrayList<>();
		if (connect != null) {
			String sql = "SELECT * FROM tbl_admin";
			try {
				var statement = connect.createStatement();
				var resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Admin user = new Admin();
					user.setId(resultSet.getInt(1));
					user.setUsername(resultSet.getString(2));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public static Integer deleteUser(Integer id) {
		Connection connect = ConnectionUtil.getConnection();
		if(connect != null) {
			String sql = "Delete from tbl_admin where admin_id = " + id;
			try {
				var statement = connect.createStatement();
				statement.executeUpdate(sql);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	public static Integer editUser(Integer id, String username, String password) {
		Connection connect = ConnectionUtil.getConnection();
		if(connect != null) {
			String sql = "UPDATE tbl_admin set username = '" + username + "', password = '" + password + "' WHERE admin_id = " + id;
			try {
				var statement = connect.createStatement();
				statement.executeUpdate(sql);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	public static Admin getOneById(Integer id) {
		Connection connect = ConnectionUtil.getConnection();
		Admin user = new Admin();
		if (connect != null) {
			String sql = "SELECT * FROM tbl_admin where admin_id="+id;
			try {
				var statement = connect.createStatement();
				var resultSet = statement.executeQuery(sql);
				if(resultSet.next()) {
					user.setId(resultSet.getInt(1));
					user.setUsername(resultSet.getString(2));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}
