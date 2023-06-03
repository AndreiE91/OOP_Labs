package javasmmr.zoowsome.services.factories.employees;

import javasmmr.zoowsome.models.animals.Constants;
import javasmmr.zoowsome.models.employees.*;

public class CaretakerFactory extends EmployeesFactory {

	public Employee getEmployee(String type) throws Exception {
		if (Constants.Employees.Caretaker.TCO_SUCCESS.equals(type)) {
			return new Caretaker();
		} else if (Constants.Employees.Caretaker.TCO_KILLED.equals(type)) {
			return new Caretaker();
		} else if (Constants.Employees.Caretaker.TCO_NO_TIME.equals(type)) {
			return new Caretaker();
		} else {
			throw new Exception("Invalid employee exception!");
		}
	}
}
