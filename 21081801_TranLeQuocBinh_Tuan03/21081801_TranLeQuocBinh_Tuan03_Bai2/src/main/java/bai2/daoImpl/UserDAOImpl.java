package bai2.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bai2.dao.UserDAO;
import bai2.models.User;

public class UserDAOImpl implements UserDAO {
	private DataSource datasource;

	public UserDAOImpl(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users";
		List<User> list = new ArrayList<User>();
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("firstName");
				String lname = rs.getString("lastName");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String dob = rs.getString("dob");
				String gender = rs.getString("gender");
				list.add(new User(id, fname, lname, email, password, dob, gender));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users (firstName, lastName, email, password, dob, gender) VALUES (?,?,?,?,?,?)";
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);) {
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getDob());
			ps.setString(6, u.getGender());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
