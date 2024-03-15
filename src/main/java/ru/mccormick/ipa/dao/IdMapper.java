package ru.mccormick.ipa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IdMapper implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getInt("calculation_id");
	}
}
