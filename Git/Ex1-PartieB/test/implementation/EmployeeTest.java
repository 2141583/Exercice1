package implementation;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.IllegalInitialSalaryException;


public class EmployeeTest {
	
	//Constantes
	private static final String ANY_NAME = "Blaise Pascal";
	private static final float SALARY_DELTA = 0.00f;   //DELTA ou EPSILON
	private static final float ANY_INITIAL_SALARY = 10000f;
	
	//Propriétés
	private Employee anEmployee = null;

	
	@BeforeEach
	public void setUpAnEmployee() {
		 anEmployee = new Employee(ANY_NAME, ANY_INITIAL_SALARY);
	}

	@Test
	public void createEmployee_shouldInitializeName(){	
		//Arrange
		
		//Act
		
		//Assert
		assertEquals(ANY_NAME, anEmployee.getName());		
	}
	
	@Test
	public void createEmployee_shouldInitializeNumber_WithAutomaticIncrement() {
		//Arrange
		Employee lastEmployee = new Employee(ANY_NAME, ANY_INITIAL_SALARY);
		int lastNumber = lastEmployee.getNumber();
		
		//Act
		Employee newEmployee = new Employee(ANY_NAME, ANY_INITIAL_SALARY);
		
		//Assert
		final int EXPECTED_NUMBER = lastNumber + Employee.EMPLOYEE_NUMBER_INCREMENT;
		assertEquals(EXPECTED_NUMBER, newEmployee.getNumber());		
	}
	
	@Test
	public void createEmployee_shouldInitializeInitialAnnualSalary() {
		//Arrange
		
		//Act
		
		//Assert
		assertEquals(ANY_INITIAL_SALARY, anEmployee.getAnnualSalary(), SALARY_DELTA);		
	}
	
	@Test
	public void createEmployee_whenInitialSalaryIsSuperiorToMax_shouldRaiseIllegalInitialSalaryException() {
		
		Assertions.assertThrows(IllegalInitialSalaryException.class, () -> {
		new Employee(ANY_NAME, Employee.MAX_INITIAL_SALARY + 1);
		});
	}
	

}