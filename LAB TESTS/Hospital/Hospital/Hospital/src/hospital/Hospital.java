package hospital;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hospital {

	private Set<Doctor> doctors;
	private Set<Pacient> pacients;

	public Hospital() {
		doctors = new HashSet<Doctor>();
		pacients = new HashSet<Pacient>();
	}

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}

	public void addPacient(Pacient pacient) {
		pacients.add(pacient);
	}

	public void heal() {
		Iterator<Doctor> itd = doctors.iterator();
		Iterator<Pacient> itt = pacients.iterator();
		while (itd.hasNext()) {
			Doctor doctor = itd.next();
			while (itt.hasNext()) {
				Pacient pacient = itt.next();
				doctor.curePacient(pacient);

			}
		}
	}
	
	public void listPacients(){
		Iterator<Pacient> it = pacients.iterator();
		while (it.hasNext()){
			Pacient pacient = it.next();
			System.out.println(pacient.toString());
		}
	}
	public void listDoctors(){
		Iterator<Doctor> it = doctors.iterator();
		while (it.hasNext()){
			Doctor doctor = it.next();
			System.out.println(doctor.toString());
		}
	}

}
