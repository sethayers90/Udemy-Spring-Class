package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student>theStudents = session.createQuery("from Student").getResultList();
			//query students: last name = "doe"
			theStudents = session.createQuery("from Student s where s.lastName='doe'").getResultList();
			//display students
			System.out.println("\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			//query studens: lastName: doe or firstName daffy
			theStudents =
					session.createQuery("from Student s where s.lastName='Doe'"
							+ "OR s.firstName='Daffy'").getResultList();
			System.out.println("\nStudents who have last name of Doe or first name of Daffy");
			displayStudents(theStudents);
			//query students where the domain is gmail
			theStudents = session.createQuery("from Student s where"
					+" s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\nStudents who's email belong to gmail domain");
			displayStudents(theStudents);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("\nDone!");
		}finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
