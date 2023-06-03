package javasmmr.zoowsome.services.factories.employees;

import javasmmr.zoowsome.models.employees.Caretaker;
import javasmmr.zoowsome.models.employees.Employee;
import javasmmr.zoowsome.services.factories.animals.Constants;

public class CaretakerFactory {

	public Employee getEmployeeFactory(String type) {
		if (Constants.Employee.Caretaker.equals(type)) { 
			return new Caretaker();
		}
	
		else{ 
			throw new RuntimeException("Invalid emp exception!"); 
		} 
			
	}		


}
