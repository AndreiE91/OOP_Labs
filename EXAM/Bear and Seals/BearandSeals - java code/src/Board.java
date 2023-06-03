import java.io.*;
import java.util.*;


public class Board {

	private char[][] board=new char[10][20];
	private String text;
	int min=200,xh,yh;
	int i,j,k,nr_seals,nr_holes,bearTime,counterSteps=0,totalSteps=0;
	Seal[] seals;
	Hole[] holes;
	Bear bear=new Bear();
	Boolean hungry=true;
	Random rand1=new Random();
	Random rand2=new Random();
	public Board(){// initialising the board with . - ice
		
		for(int i=0;i<10;i++)
			for(int j=0;j<20;j++)
			{
				board[i][j]='.';	
			}
	}
	
	
	
	public void build(){ // function for building the board, reading from the text file
		
		bearTime=bear.BearWait();
		String delims="[ ]+";
		
		try{
		FileReader f=new FileReader("Bears_Seals.txt");
		BufferedReader b= new BufferedReader(f);
		text=new String();
		
		for(i=0;i<3;i++){
		text=b.readLine();
		
		String[] each_char= text.split(delims);
		if(i==0){  bear.setBearXY(Integer.parseInt(each_char[1]), Integer.parseInt(each_char[2])); }
		if(i==1){
			j=0;
			nr_holes=Integer.parseInt(each_char[0]);
			holes=new Hole[nr_holes];
			for(k=0;k<nr_holes;k++){
				holes[k]=new Hole();
				holes[k].setHoleXY(Integer.parseInt(each_char[j+2]), Integer.parseInt(each_char[j+3]));
				board[Integer.parseInt(each_char[j+2])][Integer.parseInt(each_char[j+3])]=each_char[j+1].charAt(0);
			j=j+3;	
			
			}
				}
		if(i==2){
			j=0;
			nr_seals=Integer.parseInt(each_char[0]);
			seals=new Seal[nr_seals];
			
			for(k=0;k<nr_seals;k++){
	
				seals[k]=new Seal();
				seals[k].setSealXY(Integer.parseInt(each_char[j+2]), Integer.parseInt(each_char[j+3]));
			j=j+3;
			}
	
		}}}
		
		catch(FileNotFoundException e1){
			System.err.println("FILE Bears_Seals.txt NOT FOUND!!");
		}
		catch(IOException e2){
			System.err.println("I/O ERROR");
		}
		
		putBear();
		for(i=0;i<nr_seals;i++)		putSeals(i);
	}
	
	
	
	public void putBear(){
		board[bear.getBearX()][bear.getBearY()]='B';
	}
	
	
	
	public void putSeals(int i){
	
			if(seals[i].Dead()==false){
			if(board[seals[i].getSealX()][seals[i].getSealY()]=='B' && hungry==true) {seals[i].setDead();System.err.println("Seal nr"+(i+1)+" eaten!!");bearTime=3;counterSteps=0;hungry=false;}
			
			else
				{if(board[seals[i].getSealX()][seals[i].getSealY()]=='H') board[seals[i].getSealX()][seals[i].getSealY()]='S';
				else board[seals[i].getSealX()][seals[i].getSealY()]='s';
				}
		
		}
	}
	
	
	
	public void print(){ //function for printing the board
		
		for(int i=0;i<2;i++){
			for(int j=0;j<20;j++){
			
				if(i==0){
					if(j==0) System.out.print(" ");
					if(j<10) System.out.print(0);
					else     System.out.print(1);
						}
				
				if(i==1){
					if(j==0) System.out.print(" ");
					if(j<10) System.out.print(j);
					else     System.out.print(j-10);
						}
				
			}
			System.out.println();
		}
		
		
	for(i=0;i<10;i++){
		System.out.print(i);
		for(j=0;j<20;j++){
			System.out.print(board[i][j]);
		}System.out.println();
	}
		
	System.out.println("Bear is at: " + bear.getBearX()+" "+bear.getBearY());
	
	for(i = 0;i<nr_seals;i++){
		if(seals[i].Dead()==false) System.out.println("Seal nr"+ (i+1) +" is at: "+seals[i].getSealX()+" "+seals[i].getSealY());
	
	}
	
	System.out.println("Press Enter...");
	}
	
	
	
	public boolean GameOver(){
		
		boolean ok=true;
		for(i=0;i<nr_seals;i++)
		{
			if(seals[i].Dead()==false)
				ok=false;
		}
		return ok;
	}
	
	public void MoveSeals(){
		totalSteps++;
		counterSteps++;
		if(counterSteps==bearTime){ MoveBear(); counterSteps=0;}
		
		int x,y,xb,yb;
		
		for(i=0;i<nr_seals;i++){			

		if(seals[i].Dead()==false){
		seals[i].incBreath();
				do{
					
				x=rand1.nextInt(10);y=rand2.nextInt(20);
				}while(board[x][y]=='s' || board[x][y]=='S');
		
		xb=seals[i].getSealX();
		yb=seals[i].getSealY();

		if(board[xb][yb]=='S'){ board[xb][yb]='H'; seals[i].setBreath();}
		else board[xb][yb]='.';
		
		seals[i].setSealXY(x, y);
	   
	   if(seals[i].getBreath()==4) nearestHole(i);
	   else	putSeals(i);
		}
							}
		
		}
	
	public void MoveBear(){
		int x,y;
		hungry=true;
		bearTime=bear.BearWait();
		board[bear.getBearX()][bear.getBearY()]='H';
		
		do{
			
			x=rand1.nextInt(10);y=rand2.nextInt(20);
			}while(board[x][y]=='.' || board[x][y]=='s' || board[x][y]=='B' );
	bear.setBearXY(x, y);
	putBear();
	}
	
	public void nearestHole(int i){
		
		for(j=0;j<nr_holes;j++){
				if(Math.abs(seals[i].getSealX()-holes[j].getHoleX())+Math.abs(seals[i].getSealY()-holes[j].getHoleY())<min){
					min=Math.abs(seals[i].getSealX()-holes[j].getHoleX())+Math.abs(seals[i].getSealY()-holes[j].getHoleY());
					xh=holes[j].getHoleX();
					yh=holes[j].getHoleY();
					}
				}
			
		seals[i].setSealXY(xh,yh);
		
		if(board[xh][yh]=='S')  seals[i].setDead();
		
		
		
		System.out.println();
		System.err.println("Nearest hole for seal"+(i+1)+  ": "+xh + " " + yh);
		putSeals(i);
	}
	public int getTotalSteps(){
		return totalSteps;
	}
	
	
		}
	



