package implementation;

import java.util.ArrayList;

import exception.IllegalInitialSalaryException;

public class Employee {
	
	//Constantes
	public static final float MAX_INITIAL_SALARY = 100000f;
	public static final int EMPLOYEE_NUMBER_INCREMENT = 10;
	
	//Propri�t�s statiques
	private static int nextEmployeeNumber = EMPLOYEE_NUMBER_INCREMENT;
	
	//M�thodes statiques
	private static int getNextEmployeeNumber() {
		return Employee.nextEmployeeNumber;
	}	
	private static void updateNextEmployeeNumber() {
		Employee.nextEmployeeNumber = Employee.nextEmployeeNumber + EMPLOYEE_NUMBER_INCREMENT;
	}
	
	//Propri�t�s
	private String name;
	private final int NUMBER;
	private final float INITIAL_ANNUAL_SALARY;
	private ArrayList<SalaryIncrease> historyOfSalaryIncrease = new ArrayList<>(); 

	//Constructeurs
	public Employee(String empName, float empInitialSalary) {
		this.validateInitialSalary(empInitialSalary);
		this.name = empName;
		this.NUMBER = Employee.getNextEmployeeNumber();
		this.INITIAL_ANNUAL_SALARY = empInitialSalary; 
		updateNextEmployeeNumber();
	}

	//M�thodes
	private void validateInitialSalary(float empInitialSalary) {
		if(empInitialSalary > MAX_INITIAL_SALARY) throw new IllegalInitialSalaryException();		
	}

	public String getName() {
		return this.name;
	}

	public int getNumber() {
		return this.NUMBER;
	}

	public float getAnnualSalary() {  // pour l'instant = getInitialAnnualSalary()...
		float currentSalary = 0;
		currentSalary += INITIAL_ANNUAL_SALARY;
		for (int i = 0; i < historyOfSalaryIncrease.size(); i++) {
			currentSalary += historyOfSalaryIncrease.get(i).getSalaryIncreaseAmount(currentSalary);
		}
		return currentSalary;
	}
	
	public void applySalaryIncrease(SalaryIncrease salaryIncrease) {
		historyOfSalaryIncrease.add(salaryIncrease);
	}
	

}