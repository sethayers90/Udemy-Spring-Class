package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			//create 3 student objs
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student ("Seth", "Ayers", "seth@luv2code.com");
			Student tempStudent2 = new Student ("Sophia", "Ayers", "sophia@luv2code.com");
			Student tempStudent3 = new Student ("Jessie", "Wall", "jessie@luv2code.com");

			//start a transaction
			session.beginTransaction();
			
			//save the student obj
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			factory.close();
		}
	}

}
