package com.Pranav.Client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Pranav.Entity.Department;
import com.Pranav.Entity.Employee;
import com.Pranav.Util.HibernateUtil;

public class CriteriaQueryTest {

	public static void main(String [] args)
	{
		//updateITEmployeeSalaries();
		findAllEmployee();
	}
	
   public static void updateITEmployeeSalaries()
   {
	   System.out.println("increasing IT employee salaries by 500");
	   try(Session session=HibernateUtil.getSessionFactory().openSession())
	   {
		   	CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		   	CriteriaUpdate<Employee> criteriaUpdate=criteriaBuilder.createCriteriaUpdate(Employee.class);
		    Root<Employee> empRoot=criteriaUpdate.from(Employee.class);
		//    criteriaUpdate.set(empRoot.get("Salary"),criteriaBuilder.sum(empRoot.get("Salary"),500L));		    
			 
			 session.beginTransaction();
			 session.createQuery(criteriaUpdate).executeUpdate();
			 session.getTransaction().commit();
			 
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
   
   public static void getDeptandEmployee()
   {
	   try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery=builder.createQuery(Object[].class);
			
			Root<Employee> rootEmp=criteriaQuery.from(Employee.class);
			Root<Department> rootDept=criteriaQuery.from(Department.class);
			
		    criteriaQuery.multiselect(rootEmp,rootDept);
           criteriaQuery.where(builder.equal(rootEmp.get("department"), rootDept.get("id")));
			Query<Object[]> query=session.createQuery(criteriaQuery);
			
			List<Object[]> resultList=query.getResultList();
			for (Object[] objects : resultList) {
               Employee employee=(Employee)objects[0];
               System.out.println(employee.getId()+"\t"+employee.getName());
               Department department=(Department)objects[1];

               System.out.println(department.getId()+"\t"+department.getName());
           }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
   }
   
   
   public static void findAllEmployee()
   {
	   try
	   {
	   Session session=HibernateUtil.getSessionFactory().openSession();
	   	System.out.println("all the employees");
	   	CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
	   	CriteriaQuery<Object> cq=criteriaBuilder.createQuery();
	   	Root<Employee> from=cq.from(Employee.class);
	   	CriteriaQuery<Object> cq1=cq.select(from);
	   	TypedQuery<Object> tq=session.createQuery(cq1);
	   	
	   	List<Object>resultList=tq.getResultList();
	   	for(Object o:resultList)
	   	{
	   		Employee emp=(Employee)o;
	   		System.out.println(emp.getId()+" : "+emp.getDesignation()+" : "+emp.getName()
	   		+" : "+emp.getDepartment());
	   		
	   	}
	   	
	   }
	   catch(Exception e)
	   {
		   
	   }
	   
   }
}
