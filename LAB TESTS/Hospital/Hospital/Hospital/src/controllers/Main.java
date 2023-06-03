package controllers;

import hospital.Doctor;
import hospital.Hospital;

public class Main {
	
	public static void main(String[] args){
		
		Hospital hospital = new Hospital();
		hospital.addDoctor(new Doctor(1234567, "Anca Muresan"));
		hospital.addDoctor(new Doctor(1234568, "Ana Muresan"));
		hospital.listDoctors();
		
		
		
	}

}
