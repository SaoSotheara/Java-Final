package com.itstep.htmltip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itstep.htmltip.entity.Tip;
import com.itstep.htmltip.utils.ConnectionUtil;

public class TipDao {
	public static int save(Tip tip) {
		Connection connect = ConnectionUtil.getConnection();
		int status = 0;
		if (connect != null) {
			String sql = "INSERT INTO tbl_tip(title, description, exampleHtmlEscape) VALUES(?, ?, ?)";
			PreparedStatement statement;
			try {
				statement = connect.prepareStatement(sql);
				statement.setString(1, tip.getTitle());
				statement.setString(2, tip.getDescription());
				statement.setString(3, tip.getExampleHtmlEscape());
				
				status = statement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return status;
	}
	
	public static Tip getTip(int tipId) {

		Connection connect = ConnectionUtil.getConnection();
		Tip found = null;
		if (connect != null) {
			String sql = "SELECT * FROM tbl_tip WHERE tip_id=?";
			PreparedStatement statement;
			
			try {
				statement = connect.prepareStatement(sql);
				statement.setInt(1, tipId);
				
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					found = new Tip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return found;
	}
	
	public static List<Tip> retrieveAll() {
		Connection connect = ConnectionUtil.getConnection();
		List<Tip> list = new ArrayList<>();
		if (connect != null) {
			String sql = "SELECT * FROM tbl_tip";
			Statement statement;
			try {
				statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					Tip tip = new Tip(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4)
							);
					list.add(tip);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	public static Integer updateTip(Integer id, Tip tip) {
		Connection connect = ConnectionUtil.getConnection();
		if(connect != null) {
			String sql = "UPDATE tbl_tip set title = '" + tip.getTitle() + "', description = '" + tip.getDescription() +"', exampleHtmlEscape = '" + tip.getExampleHtmlEscape() + "' WHERE tip_id = " + id;
			try {
				var statement = connect.createStatement();
				statement.executeUpdate(sql);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	public static Tip getOneById(Integer id) {
		Connection connect = ConnectionUtil.getConnection();
		Tip tip = new Tip();
		if (connect != null) {
			String sql = "SELECT * FROM tbl_tip where tip_id="+id;
			try {
				var statement = connect.createStatement();
				var resultSet = statement.executeQuery(sql);
				if(resultSet.next()) {
					tip.setTipId(resultSet.getInt(1));
					tip.setTitle(resultSet.getString(2));
					tip.setDescription(resultSet.getString(3));
					tip.setExampleHtmlEscape(resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tip;
	}

	public static void deleteTip(Integer id) {
		Connection connect = ConnectionUtil.getConnection();
		if(connect != null) {
			String sql = "Delete from tbl_tip where tip_id = " + id;
			try {
				var statement = connect.createStatement();
				statement.executeUpdate(sql);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}