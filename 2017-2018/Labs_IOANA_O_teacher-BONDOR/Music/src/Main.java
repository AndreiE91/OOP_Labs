public class Main {

	public static void main(String[] args) {
		
		//create a band
		Instrument[] ins = {Instrument.BASS,Instrument.GUITAR, Instrument.DRUMS};
		Band band1 = new Band("Woau",2,ins) ;
		
		//create a GUITAR musician
		Musician musician1 = new Musician("Toby");
		musician1.setInstrument(Instrument.GUITAR);

		//add the musician in the band
		boolean test1 = band1.addMusician(musician1);
		System.out.println(test1);
		
		//check how many empty positions are left in the band
		System.out.println(band1.getEmptySpots());
		
		//create a BASS musician
		Musician musician2 = new Musician("John");
		musician2.setInstrument(Instrument.BASS);
		
		//add the musician in the band
		boolean test2 = band1.addMusician(musician2);
		System.out.println(test2);
		
		//check how many empty positions are left in the band
		System.out.println(band1.getEmptySpots());
		
		//
		band1.deleteMusician(musician1);
		
		System.out.println(band1.getEmptySpots());
		
		band1.printMusicians();
		
		
		Musician musician3 = new Musician("wtf");
		musician3.setInstrument(Instrument.GUITAR);
		boolean test3 = band1.addMusician(musician3);
		System.out.println(test3);
		
		
		System.out.println("NEW BAND:");
		Instrument[] ins2 = {Instrument.VOICE,Instrument.GUITAR, Instrument.DRUMS,Instrument.GUITAR};
		Band band2 = new Band("1975", 4, ins2);
		
		Musician musician4 = new Musician("Mihai");
		musician4.setInstrument(Instrument.VOICE);
		band2.addMusician(musician4);

		Musician musician5 = new Musician("Vlad");
		musician5.setInstrument(Instrument.DRUMS);
		band2.addMusician(musician5);
		
		Musician musician6 = new Musician("Andrei");
		musician6.setInstrument(Instrument.GUITAR); 
		band2.addMusician(musician6);
		
		band2.getMissingInstrument();
		
		Musician musician7 = new Musician("Bogdan");
		musician7.setInstrument(Instrument.GUITAR);
		band2.addMusician(musician7);
		
		band2.printMusicians();

		band2.getMissingInstrument();
		
		
	}
}