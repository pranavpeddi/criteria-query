package com.Pranav.Client;

import org.hibernate.Session;

import com.Pranav.Entity.Department;
import com.Pranav.Entity.Employee;
import com.Pranav.Util.*;

public class SaveData {
 public static void main(String [] args)
 {
	 try(Session session=HibernateUtil.getSessionFactory().openSession())
	 
	 {
	    Department department1=new Department();
	    department1.setLocation("London");
	    department1.setName("IT");
	 Employee employee1=new Employee("pranav", "Devloper",25000l);
	 department1.getEmployees().add(employee1);
	 employee1.setDepartment(department1);
	 
	 Employee employee2=new Employee("revanth", "Devloper",45000l);
	 department1.getEmployees().add(employee2);
	 employee2.setDepartment(department1);
	 
	 
	 

	 Department department2=new Department();
	 department2.setName("HR");
	 department2.setLocation("Thailand");
	 
	 
	 Employee employee3=new Employee("anirudh","Recrutier", 15000l);
	 department2.getEmployees().add(employee3);
	 employee3.setDepartment(department2);
	 
	 Employee employee4=new Employee("prashanth","Hr operations", 55000l);
	 department2.getEmployees().add(employee4);
	 employee4.setDepartment(department2);
	 
	 session.beginTransaction();

     session.save(department1);
     session.save(department2);

     session.getTransaction().commit();

	    
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
}
