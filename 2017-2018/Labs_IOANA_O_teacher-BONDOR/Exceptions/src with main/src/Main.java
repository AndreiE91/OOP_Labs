
public class Main {

	public static void exceptionArray (Weather[] array, int i) throws IndexArrayOOBException {
		if(i>=array.length) throw new IndexArrayOOBException("The array is out of bounds.");
	}
	
	public static int test() {
		try {
			return 0;
		} finally {
			return 1;
		}
	}

	public static int parse(String str) throws Exception {

		return Integer.parseInt(str);

	}

	public static void main(String[] args) {
		/*
		 * Weather weatherObject = new Weather(10);
		 * 
		 * test(); try { weatherObject.getDegrees(); } catch(Exception e) {
		 * e.printStackTrace(); }
		 * 
		 * 
		 * try {
		 * 
		 * // Integer myInt=Integer.parseInt("a"); //
		 * System.out.println(weatherObject.getDegrees());
		 * 
		 * } catch (NullPointerException e) { System.out.println("other message"); }
		 * catch (NumberFormatException d) { System.out.println("the other message"); }
		 * finally { System.out.println("message"); ; }
		 */
		
		Weather[] weathers=new Weather[8];
		for(int i=0;i<=8;i++) {
			try{
				exceptionArray(weathers,i);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
			System.out.println("The iteration is at " + i + " step.");
			}
		}
		
		
	}

}
