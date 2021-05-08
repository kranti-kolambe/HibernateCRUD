package com.khk;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khk.entity.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println("SessionFactory create");
		Session session = sessionFactory.openSession();
		System.out.println("Session create");
		
		  session.beginTransaction(); session.save(new Employee("KHK", "Pune", 65000));
		  System.out.println("Query hit"); session.getTransaction().commit(); //
		  session.beginTransaction().commit(); session.beginTransaction();
		  session.save(new Employee("JBK", "Pune", 55000));
		  System.out.println("Query hit"); session.getTransaction().commit();
		  session.beginTransaction(); session.save(new Employee("Sneha", "Mumbai",
		  75000)); System.out.println("Query hit"); session.getTransaction().commit();
		  session.beginTransaction(); session.save(new Employee("Kranti", "Goa",
		  70000)); System.out.println("Query hit"); session.getTransaction().commit();
		  session.beginTransaction(); session.save(new Employee("Aarti",
		  "Delhi",40000)); System.out.println("Query hit");
		  session.getTransaction().commit();
		 
		
		//fetch all record from employee 
		session.beginTransaction();
		List<Employee> el=session.createQuery("from Employee").list();
		for(Employee emp:el) {
			System.out.println(emp);
		}
		session.getTransaction().commit();
	}

}
