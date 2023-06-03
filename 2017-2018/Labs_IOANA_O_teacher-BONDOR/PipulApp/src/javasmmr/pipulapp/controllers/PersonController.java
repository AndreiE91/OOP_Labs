package javasmmr.pipulapp.controllers;

import java.util.ArrayList;

import java.util.List;


import javasmmr.pipulapp.models.MyTableModel;
import javasmmr.pipulapp.models.Person;
import javasmmr.pipulapp.views.NewPersonView;
import javasmmr.pipulapp.views.PersonView;

public class PersonController {

	private PersonView view;
	private Person model;

	private MyTableModel myTableModel = new MyTableModel();
	private NewPersonView newView = new NewPersonView();
	
private int aux = 1;
	
	public PersonController() {
		this.view = new PersonView();

		final List<Person> ps = new ArrayList<>();
		ps.add(new Person("a", 20,1));
		ps.add(new Person("b", 22,2));
		ps.add(new Person("c", 23,3));
		ps.add(new Person("d", 24,4));

		
		myTableModel.setPersons(ps);
		
		this.view.NewActionListener(e -> {
			newView.setVisible(true);
		});

		this.view.setTableModel(myTableModel);
		this.view.setVisible(true);
		
		this.newView.addCancelButtonActionListener(e ->{
			newView.setVisible(false);
		});
		
		//myTableModel.getColumnCount();
		
		this.newView.addSaveButtonActionListener(action ->{
			ps.add(new Person(newView.getName(), Integer.parseInt(newView.getAge()), aux));
			aux++;
			myTableModel.setPersons(ps);
			this.view.repaint();
		});
		
	}


	
	

	
}
