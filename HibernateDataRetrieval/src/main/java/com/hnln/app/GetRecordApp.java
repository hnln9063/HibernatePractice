package com.hnln.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hnln.model.Student;

public class GetRecordApp {
	public static void main(String args[]) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).
			buildSessionFactory();
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			// To Retrieve only id=1 data
			// Student student = session.get(Student.class, 1); // [Early/Eager Loading]
			// System.out.println(student);
			
			// load() and getReference() are same. getReference() is updated one.
			// Student student = session.load(Student.class, 1);
			// load() and getReference() are [Lazy Loading]
			Student student = session.getReference(Student.class, 1);
			
			// If we use get() and if we want to retrieve data which is not present in database, it returns null object.
			// If we use getReference() and if we want to retrieve data which is not present in database, it returns an object with specified id.
			// So it raises, ObjectNotFound Exception
			
			if(student != null) {
				System.out.println("Id is : "+ student.getSid());
				System.out.println("Name is : "+ student.getsName());
				System.out.println("City is : "+ student.getScity());
			} else {
				System.out.println("There are no data or record with given id");
			}
			
		} catch(HibernateException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
			sessionFactory.close();
		}
		
	}
}
