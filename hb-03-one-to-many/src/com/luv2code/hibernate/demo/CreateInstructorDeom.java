package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDeom {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			Instructor tmpInstructor = 
					new Instructor("Seth", "Ayers", "seth@email.com");
			InstructorDetail tmpInstructorDetail=
					new InstructorDetail(
							"http://youtube.com",
							"gaming");
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
			session.close();
			factory.close();
		}
	}

}
