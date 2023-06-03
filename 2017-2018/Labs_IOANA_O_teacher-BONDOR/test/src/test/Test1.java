package test;

public class Test1 {
	int numberOfStudents;
	
	void setNumber(int nr) {
		numberOfStudents = nr;
	}

	int getNumber() {
		return numberOfStudents;
	}
	
	
	// is very important to use "this." in order not to make any inconveniences
	void increaseNumber(int numberOfStudents) {
		this.numberOfStudents+=numberOfStudents;
	}

}

