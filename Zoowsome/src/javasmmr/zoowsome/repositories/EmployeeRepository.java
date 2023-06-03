package javasmmr.zoowsome.repositories;

import org.w3c.dom.Element;

import javasmmr.zoowsome.models.animals.Constants;
import javasmmr.zoowsome.models.employees.Caretaker;
import javasmmr.zoowsome.models.employees.Employee;

public class EmployeeRepository extends EntityRepository<Employee> {

	private static final String XML_FILENAME = "Employees.xml";

	public EmployeeRepository() {
		super(XML_FILENAME, Constants.XML_TAGS.EMPLOYEE);
	}

	protected Employee getEntityFromXmlElement(Element element) {
		String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
		switch (discriminant) {
		case Constants.Employees.Caretaker.TCO_KILLED:
			Employee killed = new Caretaker();
			killed.decodeFromXml(element);
			return killed;
		case Constants.Employees.Caretaker.TCO_NO_TIME:
			Employee noTime = new Caretaker();
			noTime.decodeFromXml(element);
			return noTime;
		case Constants.Employees.Caretaker.TCO_SUCCESS:
			Employee success = new Caretaker();
			success.decodeFromXml(element);
			return success;
		default:
			break;
		}
		return null;
	}

}
