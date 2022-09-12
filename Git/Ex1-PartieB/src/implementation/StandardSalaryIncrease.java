package implementation;

public class StandardSalaryIncrease implements SalaryIncrease {
	
	private float salaryIncreasePercentage;
	
	public StandardSalaryIncrease(float salaryIncreasePercentage) {
		this.salaryIncreasePercentage = salaryIncreasePercentage;
	}
	
	public float getSalaryIncreasePercentage() {
		return this.salaryIncreasePercentage;
	}
	@Override
	public float getSalaryIncreaseAmount(float salary) {
		return this.salaryIncreasePercentage/100 * salary;
	}
}
