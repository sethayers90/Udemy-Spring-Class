package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
		
			//start a transaction
			session.beginTransaction();
			
			int theId=1;
			Instructor tmpInstructor = session.get(Instructor.class, theId);
			
			Course tmpCourse1 = new Course("Java");
			Course tmpCourse2= new Course("C");
			
			tmpInstructor.add(tmpCourse1);
			tmpInstructor.add(tmpCourse2);
			session.save(tmpCourse1);
			session.save(tmpCourse2);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			session.close();
			factory.close();
		}
	}

}
