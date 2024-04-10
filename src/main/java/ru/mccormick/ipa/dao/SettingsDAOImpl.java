package ru.mccormick.ipa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.models.Settings;

@Component
public class SettingsDAOImpl implements SettingsDAO {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SettingsDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Settings findSettingsById(int id) {
		String query = "SELECT * FROM Settings WHERE settings_id=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}
		}, new SettingsMapper())
		.stream().findAny().orElse(null);
	}
	
	@Override
	public Settings findSettingsByUserId(int userId) {
		String query = "SELECT * FROM Settings WHERE user_id=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, userId);
			}
		}, new SettingsMapper())
		.stream().findAny().orElse(null);
	}

	@Override
	public void save(Settings settings) {
		String query = "INSERT INTO Settings("
				+ "user_id, raw_oil, gas_condensate, automobiles_gasoline, diesel_fuel, lighting_kerosene, fuel_oil, "
				+ "propane_and_butane, compressed_hc_gases, bitumen, coking_coal, coal, natural_gas, firewood) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setInt(1, settings.getUserId());
				ps.setArray(2, con.createArrayOf("DOUBLE", settings.getRawOil()));
				ps.setArray(3, con.createArrayOf("DOUBLE", settings.getGasCondensate()));
				ps.setArray(4, con.createArrayOf("DOUBLE", settings.getAutomobilesGasoline()));
				ps.setArray(5, con.createArrayOf("DOUBLE", settings.getDieselFuel()));
				ps.setArray(6, con.createArrayOf("DOUBLE", settings.getLightingKerosene()));
				ps.setArray(7, con.createArrayOf("DOUBLE", settings.getFuelOil()));
				ps.setArray(8, con.createArrayOf("DOUBLE", settings.getPropaneAndButane()));
				ps.setArray(9, con.createArrayOf("DOUBLE", settings.getCompressedHydrocarbonGases()));
				ps.setArray(10, con.createArrayOf("DOUBLE", settings.getBitumen()));
				ps.setArray(11, con.createArrayOf("DOUBLE", settings.getCokingCoal()));
				ps.setArray(12, con.createArrayOf("DOUBLE", settings.getCoal()));
				ps.setArray(13, con.createArrayOf("DOUBLE", settings.getNaturalGas()));
				ps.setArray(14, con.createArrayOf("DOUBLE", settings.getFirewood()));
				
				return ps;
			}
		});
	}

	@Override
	public void update(Settings settings, int id) {
		String query = "UPDATE Settings SET user_id=?, "
				+ "raw_oil=?, gas_condensate=?, automobiles_gasoline=?, diesel_fuel=?, lighting_kerosene=?, fuel_oil=?, "
				+ "propane_and_butane=?, compressed_hc_gases=?, bitumen=?, coking_coal=?, coal=?, natural_gas=?, firewood=? "
				+ "WHERE settings_id=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setInt(1, settings.getUserId());
				ps.setArray(2, con.createArrayOf("DOUBLE", settings.getRawOil()));
				ps.setArray(3, con.createArrayOf("DOUBLE", settings.getGasCondensate()));
				ps.setArray(4, con.createArrayOf("DOUBLE", settings.getAutomobilesGasoline()));
				ps.setArray(5, con.createArrayOf("DOUBLE", settings.getDieselFuel()));
				ps.setArray(6, con.createArrayOf("DOUBLE", settings.getLightingKerosene()));
				ps.setArray(7, con.createArrayOf("DOUBLE", settings.getFuelOil()));
				ps.setArray(8, con.createArrayOf("DOUBLE", settings.getPropaneAndButane()));
				ps.setArray(9, con.createArrayOf("DOUBLE", settings.getCompressedHydrocarbonGases()));
				ps.setArray(10, con.createArrayOf("DOUBLE", settings.getBitumen()));
				ps.setArray(11, con.createArrayOf("DOUBLE", settings.getCokingCoal()));
				ps.setArray(12, con.createArrayOf("DOUBLE", settings.getCoal()));
				ps.setArray(13, con.createArrayOf("DOUBLE", settings.getNaturalGas()));
				ps.setArray(14, con.createArrayOf("DOUBLE", settings.getFirewood()));
				ps.setInt(15, id);
				
				return ps;
			}
		});
	}	

	@Override
	public void delete(int id) {
		String query = "DELETE FROM Settings WHERE settings_id=?";
		
		try {
			jdbcTemplate.update(query, id);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
