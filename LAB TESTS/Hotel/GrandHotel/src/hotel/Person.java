package hotel;

import java.util.InputMismatchException;

import utils.Constants;

public class Person {

	private long SSN;
	private String name;
	private int day;
	private int month;
	private int year;
	private boolean in;
	private String roomID;

	public Person(long SSN, String name, int day, int month, int year, String roomID) throws InputMismatchException {

		if ((SSN < Math.pow(10, Constants.SSN_LENGTH - 1)) || (SSN > Math.pow(10, Constants.SSN_LENGTH))) {
			throw new InputMismatchException("The ID donesn't have 13 digits!");
		}
		this.SSN = SSN;
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.roomID = roomID;
		this.in = true;
	}

	public long getSSN() {
		return this.SSN;
	}

	public void setSSN(long SSN) {
		this.SSN = SSN;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;

	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;

	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;

	}

	public String getRoomID() {
		return this.roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public boolean getIn() {
		return this.in;
	}

	public void setIn(boolean in) {
		this.in = in;
	}

}
