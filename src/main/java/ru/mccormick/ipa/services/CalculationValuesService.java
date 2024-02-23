package ru.mccormick.ipa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mccormick.ipa.dao.CalculationValuesDAO;
import ru.mccormick.ipa.models.CalculationValues;

@Service
public class CalculationValuesService {

	private CalculationValuesDAO calculationValuesDAO;
	
	@Autowired
	public CalculationValuesService(CalculationValuesDAO calculationValuesDAO) {
		this.calculationValuesDAO = calculationValuesDAO;
	}
	
	public CalculationValues findById(int id) {
		return calculationValuesDAO.findValesById(id);
	}
	
	public List<CalculationValues> getValuesList(int calculationId) {
		return calculationValuesDAO.getListOfCalculationValues(calculationId);
	}
	
	public void save(CalculationValues calculationValues) {
		calculationValuesDAO.save(calculationValues);
	}
	
	public void saveCalculationValuesList(List<CalculationValues> list) {
		calculationValuesDAO.saveCalculationValuesList(list);
	}
	
	public void update(CalculationValues calculationValues, int id) {
		calculationValuesDAO.update(calculationValues, id);
	}
	
	public void delete(int id) {
		calculationValuesDAO.delete(id);
	}
}
