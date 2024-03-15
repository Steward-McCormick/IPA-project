package ru.mccormick.ipa.dao;

import java.util.List;

import ru.mccormick.ipa.models.Calculation;

public interface CalculationDAO {

	public Calculation findCalculationById(int id);
	
	public List<Calculation> findAllUsersCalculations(int userId);
	
	public int save(Calculation calculation);
	
	public void update(Calculation calculation, int id);
	
	public void delete(int id);
}
