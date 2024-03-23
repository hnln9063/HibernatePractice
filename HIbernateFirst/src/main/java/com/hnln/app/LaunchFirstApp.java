package com.hnln.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hnln.model.Student;


public class LaunchFirstApp {
	public static void main(String args[]) {
		// Step 01: Configuration Object
		Configuration config = new Configuration();
		
		// Step 02: Configure hibernate.cfg.xml to Configuration Object
		// If the configuration file is named as "hibernate.cfg.xml", it automatically recognizes the file
		// If it is named different, then we need to specify the cfg.xml file name
		config.configure();
		
		// Step 03: Create SessionFactory Object
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		// Step 04: Get the Session Object from Session Factory
		Session session = sessionFactory.openSession();
		
		// Step 05: Begin the Transaction within Session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		
		student.setSid(1);
		student.setsName("HNLN");
		student.setScity("Bengaluru");
		
		// Step 06: Perform Operation
		session.save(student);

		// Step 07: Perform Transaction operations
		transaction.commit();
		
		// Step 08: Close the session
		session.close();
		
		
		
	}
}
