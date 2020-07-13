package com.Pranav.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "emp_id")
	private long id;
	
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="designation",nullable = false)
	private String designation;
	
	@Column(name="salary",nullable = false)
	private Long Salary;
	
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;


	
	public Employee( String name, String designation,Long salary) {
		super();
	
		this.name = name;
		this.designation = designation;
		this.Salary = salary;

	}

	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Long getSalary() {
		return Salary;
	}


	public void setSalary(Long salary) {
		this.Salary = salary;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", Salary=" + Salary+
				 "]";
	}
	
	
	
	
	
	
	
	
}
