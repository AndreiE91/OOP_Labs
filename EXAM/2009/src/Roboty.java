import java.awt.Point;
import java.util.ArrayList;

public class Roboty {
	private Point myPos; 
	
	ArrayList<Point> orientation; //vector de orientari
	int crtOrt; //orientarea curenta
	
	public Roboty(Point myPos){
		this.myPos = myPos;
		initOrint();
	}
	
	public Roboty(int x, int y){
		this.myPos = new Point(x,y);
		initOrint();
	}
	
	public int x(){
		return this.myPos.x; 
	}
	
	public int y(){
		return this.myPos.y;
	}
	
	private void initOrint(){
		this.orientation = new ArrayList<Point>();
		this.crtOrt = 1; 
		orientation.add(new Point(-1,0));  // sus
		orientation.add(new Point(0,1)); // dreapta
		orientation.add(new Point(1,0)); // stanga
		orientation.add(new Point(0,-1)); // jos
	}
	
	public void turnRight(){
		this.crtOrt = Math.floorMod(this.crtOrt+1,4); 
		System.out.println("Sunt orientat in: " + this.orientation.get(crtOrt));
	}
	
	public void turnLeft(){
		this.crtOrt = Math.floorMod(this.crtOrt-1,4); 
		System.out.println("Sunt orientat in: " + this.orientation.get(crtOrt));

	}
	
	public void step(){
		this.myPos.x += this.orientation.get(crtOrt).x;
		this.myPos.y += this.orientation.get(crtOrt).y;
	}
	
	public Point getPos(){
		return this.myPos;
	}
	
	public Point getNextPossiblePoisition(){
		//returneaza pozitia lui daca ar face un step (nu se schimba nimic) 
		return new Point(this.myPos.x + this.orientation.get(crtOrt).x,this.myPos.y + this.orientation.get(crtOrt).y);
	}
	
	public Point look(char lookPos){
		//chestia asta determina pozitia lui daca s-ar intoarce spre f/b/r/l si ar face un pas
		switch(lookPos){
		case 'f':
			return new Point(this.myPos.x + this.orientation.get(crtOrt).x, this.myPos.y + this.orientation.get(crtOrt).y);
		case 'b':
			return new Point(this.myPos.x - this.orientation.get(crtOrt).x, this.myPos.y - this.orientation.get(crtOrt).y);
		case 'r':
			return new Point(this.myPos.x + this.orientation.get(Math.floorMod(this.crtOrt+1,4)).x, this.myPos.y + this.orientation.get(Math.floorMod(this.crtOrt+1,4)).y);
		case 'l':
			return new Point(this.myPos.x + this.orientation.get(Math.floorMod(this.crtOrt-1,4)).x, this.myPos.y + this.orientation.get(Math.floorMod(this.crtOrt-1,4)).y);
		}
		return null;
	}
		

}
