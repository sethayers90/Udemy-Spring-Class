package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			//create the objs
//			Instructor tmpInstructor = 
//					new Instructor ("Chad","Darby","darby@luv2code.com");
//			InstructorDetail tmpInstructorDetail=
//					new InstructorDetail(
//					"http://www.luv2code.com/youtube",
//					"luv 2 code");
			Instructor tmpInstructor = 
					new Instructor ("Seth","Ayers","seth@email.com");
			InstructorDetail tmpInstructorDetail=
					new InstructorDetail(
					"http://www.youtube.com",
					"procrastinate");
			//associtate the objs
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			System.out.println("Saving Instructor: " + tmpInstructor);
			session.save(tmpInstructor);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			factory.close();
		}
	}

}
