package javasmmr.pipulapp.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	private List<Person> persons;
	
	@Override
	public int getColumnCount() {
		return 3;
//return persons.size();
	}

	@Override
	public int getRowCount() {
		return 4;
	}

	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person currentPerson = (Person) persons.toArray()[rowIndex];
        switch (columnIndex) {
            case 0:
                return currentPerson.getName();
            case 1:
                return currentPerson.getAge();
            case 2:
            	return currentPerson.getId();
        }
        return null;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}




