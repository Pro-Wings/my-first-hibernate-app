package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Student;

public class TestHibernateApp {
	
	public static void main(String[] args) {
		
		Student std1 = new Student();
		std1.setRoll(10);
		std1.setName("Ram");
		std1.setAddress("Pune");
		
		Configuration conf = new Configuration();
		
		conf.configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(std1);
		
		txn.commit();
		
		System.out.println("student object saved to DB successfully!!!");
		session.close();
		
		
		
		
	}

}
