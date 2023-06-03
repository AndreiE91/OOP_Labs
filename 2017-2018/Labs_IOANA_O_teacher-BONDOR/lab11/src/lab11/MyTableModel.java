package lab11;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class MyTableModel extends AbstractTableModel {

	private List<Person> persons;

	@Override
	public int getRowCount() {
		return persons.size();
	}

	@Override
	public int getColumnCount() {
		return 3; // hardcoded for now
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person currentPerson = (Person) persons.toArray()[rowIndex];
		switch (columnIndex) {
		case 0:
			return currentPerson.getId();
		case 1:
			return currentPerson.getName();
		case 2:
			return currentPerson.getAge();
		}
		return null;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
