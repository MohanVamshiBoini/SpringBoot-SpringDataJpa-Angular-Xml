package com.cap.anurag.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Emptablexml")
@XmlRootElement (name = "employee")
@XmlAccessorType(XmlAccessType.FIELD) // annotation we set the name for the XML output root element.
public class Employee {
	@Id
	 @GeneratedValue
	// @JacksonXmlProperty we set the name and salary attributes to be the
	// properties of City element in the XML output

	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Employee(Integer id, String name, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
