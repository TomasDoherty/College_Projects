
package ie.lyit.flight;

public interface Payable {
	public abstract double calculateWage(double taxPercentage);
	
	double incrementSalary(double incrementAmount);
}

