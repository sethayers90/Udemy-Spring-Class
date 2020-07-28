package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			
			//New Code
			int studentId=1;

			//now get a new session & start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("\nGetting student w/id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating...");
			
			myStudent.setFirstName("Scooby");
			//commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating.....");
			session.createQuery("update Student set email='foo@gmail.com'")
			.executeUpdate();
			
			session.getTransaction().commit();


			System.out.println("Done!");
		}finally{
			factory.close();
		}
	}

}
