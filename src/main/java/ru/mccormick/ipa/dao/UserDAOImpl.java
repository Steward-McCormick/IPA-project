package ru.mccormick.ipa.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.models.User;

@Component
public class UserDAOImpl implements UserDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User findUserById(int id) {
		String query = "SELECT * FROM User WHERE user_id=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}
		}, new UserMapper())
		.stream().findAny().orElse(null);
	}
	
	@Override
	public User findUserByEmail(String email) {
		String query = "SELECT * FROM User WHERE email=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
			}
		}, new UserMapper())
		.stream().findAny().orElse(null);
	}

	@Override
	public void save(User user) {
		String query = "INSERT INTO User(email, password) VALUES(?, ?)";
		
		jdbcTemplate.update(query, user.getEmail(), user.getPassword());
	}

	@Override
	public void update(User user, int id) {
		String query = "UPDATE User SET email=?, password=? WHERE id=?";
		
		jdbcTemplate.update(query, user.getEmail(), user.getPassword(), id);
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM User WHERE id=?";
		
		jdbcTemplate.update(query, id);
	}

}
























