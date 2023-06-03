//<T> is a wild card
// t u v 

//public class Box<  T, V> {
//public class Box< T extends A>{
//public class Box< T extends Content & many interfaces, but only one class which is always the first here in the list>{
public class Box<T extends Content> {

	private int id;
	private T content;
	
	public Box( T content ) {
		this.content = content;
	}
	
	public T getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
