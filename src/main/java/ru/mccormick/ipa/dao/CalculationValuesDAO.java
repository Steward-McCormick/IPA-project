package ru.mccormick.ipa.dao;

import java.util.List;

import ru.mccormick.ipa.models.CalculationValues;

public interface CalculationValuesDAO {

	public CalculationValues findValesById(int id);
	
	public List<CalculationValues> getListOfCalculationValues(int calculationId);
	
	public void save(CalculationValues values);
	
	public void saveCalculationValuesList(List<CalculationValues> list);
	
	public void update(CalculationValues values, int id);
	
	public void delete(int id);
}
