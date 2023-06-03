package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Person;
import views.MyTableModel;
import views.NewPersonView;
import views.PersonView;

public class PersonController {
	private PersonView view;
	private NewPersonView view1;
	private Person model;
	private int aux = 1;

	private MyTableModel myTableModel = new MyTableModel();

	public PersonController() {
		this.view = new PersonView();
		this.view1 = new NewPersonView();
		final List<Person> ps = new ArrayList();

		myTableModel.setPersons(ps);

		this.view.setTableModel(myTableModel);
		this.view.setVisible(true);

		this.view.addNew(e -> {
			this.view1.setVisible(true);
		});

		this.view1.cancel(e -> {
			this.view1.setVisible(false);
		});
		this.view1.save(e -> {
			ps.add(new Person(view1.getName(), Integer.parseInt(view1.getAge()), aux));
			aux++;
			myTableModel.setPersons(ps);
			this.view.repaint();
		});
	}

}