package javasmmr.zoowsome.models.employees;

import java.math.BigDecimal;
import org.w3c.dom.Element;

import javasmmr.zoowsome.models.interfaces.XML_Parsable;

import static javasmmr.zoowsome.repositories.EmployeeRepository.createNode;
import java.util.Random;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public abstract class Employee implements XML_Parsable{

	private String name;
	Random random = new Random();
	private long id = random.nextLong();
	private BigDecimal salary;
	private boolean isDead = false;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}
	
	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean getIsDead() {
		return isDead;
	}
	
	public Employee() {}
	
	public Employee(String name, long id, BigDecimal salary, boolean isDead) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.isDead = isDead;
	}
	
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "id", String.valueOf(this.id));
		createNode(eventWriter, "salary", String.valueOf(this.salary));
		createNode(eventWriter, "isDead", String.valueOf(this.isDead));
		}
	
	public void decodeFromXml(Element element) {
		setName(element.getElementsByTagName("name").item(0).getTextContent());
		setId(Long.valueOf(element.getElementsByTagName("id").item(0).getTextContent()));
		setSalary(BigDecimal.valueOf(Long.parseLong((element.getElementsByTagName("salary").item(0).getTextContent()))));//WHAAAT
		setIsDead(Boolean.valueOf(element.getElementsByTagName("isDead").item(0).getTextContent()));
		}
	
}
