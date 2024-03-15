package ru.mccormick.ipa.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.mccormick.ipa.models.Settings;

public class SettingsMapper implements RowMapper<Settings> {

	@Override
	public Settings mapRow(ResultSet rs, int rowNum) throws SQLException {
		Settings settings = new Settings();
				
		settings.setSettingsId(rs.getInt("settings_id"));
		settings.setUserId(rs.getInt("user_id"));
		
		// setting settings values
		Array rawOil = rs.getArray("raw_oil");
		settings.setRawOil((Double[])rawOil.getArray());
	
		Array gasCondensat = rs.getArray("gas_condensate");
		settings.setGasCondensate((Double[])gasCondensat.getArray());
		
		Array automobileGasoline = rs.getArray("automobiles_gasoline");
		settings.setAutomobilesGasoline((Double[])automobileGasoline.getArray());
		
		Array dieselFuel = rs.getArray("diesel_fuel");
		settings.setDieselFuel((Double[])dieselFuel.getArray());
		
		Array lightingKerosene = rs.getArray("lighting_kerosene");
		settings.setLightingKerosene((Double[])lightingKerosene.getArray());
		
		Array fuelOil = rs.getArray("fuel_oil");
		settings.setFuelOil((Double[])fuelOil.getArray());
		
		Array propaneButane = rs.getArray("propane_and_butane");
		settings.setPropaneAndButane((Double[])propaneButane.getArray());
		
		Array compressedHcGases = rs.getArray("compressed_hc_gases");
		settings.setCompressedHydrocarbonGases((Double[])compressedHcGases.getArray());
		
		Array bitumen = rs.getArray("bitumen");
		settings.setBitumen((Double[])bitumen.getArray());
		
		Array cokingCoal = rs.getArray("coking_coal");
		settings.setCokingCoal((Double[])cokingCoal.getArray());
		
		Array coal = rs.getArray("coal");
		settings.setCoal((Double[])coal.getArray());
		
		Array naturalGas = rs.getArray("natural_gas");
		settings.setNaturalGas((Double[])naturalGas.getArray());
		
		Array firewood = rs.getArray("firewood");
		settings.setFirewood((Double[])firewood.getArray());
		
//		settings.setRawOil((double[])(rs.getArray("raw_oil").getArray()));
//		settings.setGasCondensate((double[])(rs.getArray("gas_condensat").getArray()));
//		settings.setAutomobilesGasoline((double[])(rs.getArray("autompbile_gasoline").getArray()));
//		settings.setDieselFuel((double[])(rs.getArray("diesel_gasoline").getArray()));
//		settings.setLightingKerosene((double[])(rs.getArray("lighting_kerosene").getArray()));
//		settings.setFuelOil((double[])(rs.getArray("fuel_oil").getArray()));
//		settings.setPropaneAndButane((double[])(rs.getArray("propane_butane").getArray()));
//		settings.setCompressedHydrocarbonGases((double[])(rs.getArray("compressed_hc_gases").getArray()));
//		settings.setBitumen((double[])(rs.getArray("bitumen").getArray()));
//		settings.setCokingCoal((double[])(rs.getArray("coking_coal").getArray()));
//		settings.setCoal((double[])(rs.getArray("coal").getArray()));
//		settings.setNaturalGas((double[])(rs.getArray("natural_gas").getArray()));
//		settings.setFirewood((double[])(rs.getArray("firewood").getArray()));
		
		return settings;
	}

}
