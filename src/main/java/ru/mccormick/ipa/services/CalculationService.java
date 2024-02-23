package ru.mccormick.ipa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mccormick.ipa.dao.CalculationDAO;
import ru.mccormick.ipa.models.Calculation;
import ru.mccormick.ipa.models.CalculationHistory;

@Service
public class CalculationService {

	private CalculationDAO calculationDAO;
	
	@Autowired
	public CalculationService(CalculationDAO calculationDAO) {
		this.calculationDAO = calculationDAO;
	}
	
	public Calculation findById(int id) {
		return calculationDAO.findCalculationById(id);
	}
	
	public List<Calculation> getAllUsersCalc(int userId) {
		return calculationDAO.findAllUsersCalculations(userId);
	}
	
	public CalculationHistory getUsersCalcHistory(int userId) {
		return new CalculationHistory(userId, getAllUsersCalc(userId));
	}
	
	public void save(Calculation calculation) {
		calculationDAO.save(calculation);
	}
	
	public void update(Calculation calculation, int id) {
		calculationDAO.update(calculation, id);
	}
	
	public void delete(int id) {
		calculationDAO.delete(id);
	}
}
