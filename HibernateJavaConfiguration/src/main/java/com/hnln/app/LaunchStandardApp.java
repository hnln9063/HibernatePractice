package com.hnln.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hnln.model.Student;

public class LaunchStandardApp {
	public static void main(String args[]) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		config = new Configuration();
		
		/* As we used hibernate.properties file below code is not required
		// config.configure(); We can skip this by adding following code
		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hnln_DB");
		config.setProperty("hibernate.connection.password", "hnln92");
		config.setProperty("hibernate.connection.username", "root");
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		config.setProperty("hibernate.hbm2ddl.auto", "update");
		config.setProperty("hibernate.show_sql", "true");
		config.setProperty("hibernate.format_sql", "true");
		*/
		
		// Mapping the model class
		// We cannot map the class in hiberante.properties file so we should map here itself
		config.addAnnotatedClass(Student.class);
		
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		
		Student student = new Student();
		student.setSid(4);
		student.setsName("RCB");
		student.setScity("Banglore");
		
		try {
			transaction = session.beginTransaction();
			session.persist(student);
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();
 			} else {
 				transaction.rollback();
 			}
			session.close();
			sessionFactory.close();
		}
	}
}
