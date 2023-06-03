package javasmmr.zoowsome.services.factories.employees;

import javasmmr.zoowsome.models.employees.*;

public abstract class EmployeesFactory {
	public abstract Employee getEmployee(String type) throws Exception;

}
