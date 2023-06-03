public class Band {

	private int nrOfMembers;
	private String name;
	private Instrument[] bandInstruments;
	private Musician[] musicians;

	public Band( String name, int nrOfMembers, Instrument[] bandInstruments) {
		this.name = name;
		this.musicians = new Musician[nrOfMembers];
		this.bandInstruments = bandInstruments;
		this.nrOfMembers=nrOfMembers;
	}

	//print musicians from the band
	public void printMusicians() {
		
		for ( int i=0; i < musicians.length;i++) {
			if(musicians[i]!=null) {
				System.out.println("musician "+ i + " is " + musicians[i].getUsername());
			}
		}
		
	}	
	
	public boolean addMusician(Musician musician){

		int spots = getEmptySpots();
		if(checkIfAvailable(musician.getInstrument()) == 0) {
			System.out.println("No available places for instrument " + musician.getInstrument());
			return false;
		}

		boolean added = false;

		for(int i=0;i<bandInstruments.length;i++){

			if(musician.getInstrument().equals(bandInstruments[i]) && checkIfAvailable(musician.getInstrument())>0){
				//add to empty spot
				for(int j=0;j<nrOfMembers;j++){
					if(!added) {
						if (musicians[j] == null) {
							musicians[j] = musician;
							added = true;
						}

					}
				}
			}

		}

		return (spots == getEmptySpots()+1);
	}

	//find how many free positions are in the band
	public int getEmptySpots() {
		
		int emptySpots = 0;
		for (int i=0; i< musicians.length; i++) {
			if(musicians[i]!=null) {
				emptySpots++;
			}
		}
		return emptySpots;
		
	}
	
	
	//check if you still need that instrument in your band
	public int checkIfAvailable(Instrument instrument){
		
		//we find how many instruments are of a certain type
		int numberOfInstrument = 0;
		for ( int i=0; i< bandInstruments.length;i++) {
			if(bandInstruments[i].equals(instrument)) {
				numberOfInstrument++;
			}
		}
			
		//we find how many of the spots are full
		int fullSpots = 0;
		for(int j=0; j<nrOfMembers;j++) {
			if(musicians[j]!=null) {
				if (musicians[j].getInstrument().equals(instrument))
					fullSpots++;
			}
		}
		
		//we return the number of free spots
		return numberOfInstrument-fullSpots;
		
	}

	//delete a musician from the band
	public void deleteMusician(Musician musician) {

		for (int i = 0; i < musicians.length; i++) {
			if (musicians[i]!=null && musicians[i].getUsername().equals(musician.getUsername())) {
				musicians[i] = null;
				System.out.println(musician.getUsername() + " was fired from the band");
			}
		}
	}
	

	//see how many instrument are missing from each kind
	public void getMissingInstrument(){
		Instrument[] instrumentArray = Instrument.values();
		for(int i=0;i<instrumentArray.length;i++){
			System.out.println(instrumentArray[i]+" - "+checkIfAvailable(instrumentArray[i]));
		}
	}

	
	
}
