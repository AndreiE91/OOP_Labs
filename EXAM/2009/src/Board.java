import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Board {
char prevElem;
	
	private Roboty roboty; 
	char[][] pos;
	int xBound,yBound;
	
	public Board(){
		pos = new char[50][50];
		this.readFromFile();
		prevElem = ' ';
	}
	
	private void readFromFile(){
		try{
			try(BufferedReader reader = new BufferedReader(new FileReader("./roboty.txt"))){

				String line;
				int i=0;
				int j=0;
				while((line = reader.readLine()) != null){
					for(j=0;j<line.length();j++)
						pos[i][j] = line.charAt(j);
					i++;
					this.yBound = j; 
				}
				this.xBound = i;
				
				
				for(i=0;i<xBound;i++)
					for(j=0;j<yBound;j++){
						if(pos[i][j] == 'R')
							this.roboty = new Roboty(i,j);
					}

				
				
				System.out.println(" Roboty: " + roboty);
				
				
				reader.close();
			}
		}catch (IOException e){
			System.out.println("Invalid file!");
		}
	}
	
	
	public void printBoard(){
		for(int i=0;i<xBound;i++)
		{
			for(int j=0;j<yBound;j++)
				System.out.print(pos[i][j] );
			System.out.println();
		}
	}
	
	public boolean checkOutOfBounds(Point p){
		if(p.x<0 || p.x>=xBound || p.y<0 || p.y >=yBound || pos[p.x][p.y] == 'W')
			return false; 
		return true; 
	}
	
	public void turnRoboty(boolean turnLeft){
		if(turnLeft){
			this.roboty.turnLeft();
		}else{
			this.roboty.turnRight();
		}
	}
	
	
	
	public void lookRoboty(char look){
		if(pos[roboty.look(look).x][roboty.look(look).y] == ' ')
			System.out.println("D");
		else
			System.out.println("W");
	}
	
	public void stepRoboty(){		
		
		if(checkOutOfBounds(roboty.getNextPossiblePoisition())){
			System.out.println("Ajung");
			pos[roboty.x()][roboty.y()] = prevElem;
			roboty.step();
			prevElem = pos[roboty.x()][roboty.y()];
			pos[roboty.x()][roboty.y()] = 'R';
		}else{
			System.out.println("\n Impossible move. \n");			
		}
		
	}
	public boolean gameOver(){
		return false;
	}

	public void inputComand(){
		String[] cmd = IO.getCommand();
		boolean ok = false;  // verificare daca e comanda buna
		if(cmd.length==1){    //daca ai comanda doar de o litera
			if(cmd[0].equals("s") || cmd[0].equals("S")){
				this.stepRoboty();
				ok = true; 
			}
		}else if(cmd.length == 2){  //daca e comanda de 2 litere
			if(cmd[0].equals("t") || cmd[0].equals("T"))
				if(cmd[1].equals("l")){
					this.turnRoboty(true);
					ok=true;
				}else{
					this.turnRoboty(false);
					ok=true;
				}
			if(cmd[0].equals("l") || cmd[0].equals("L")){
				this.lookRoboty(cmd[1].charAt(0));
				ok=true;
			}
		}
		
		if(ok==false){
			System.out.println("Comanda gresita!");
		}
	}
}