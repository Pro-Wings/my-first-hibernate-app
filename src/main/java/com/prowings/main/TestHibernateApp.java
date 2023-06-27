package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Student;
import com.prowings.entity.Student2;

public class TestHibernateApp {
	
	public static void main(String[] args) {
		
		Student2 std1 = new Student2();
		std1.setId(4);
		std1.setRoll(123);
		std1.setName("DDD122");
		std1.setAddress("XXX122");
		
		Configuration conf = new Configuration();
		
		conf.configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
//		System.out.println(">>>>>>>>save method returned : " +session.save(std1));
//		session.saveOrUpdate(std1);
		
//		session.persist(std1);
		
//		session.delete(std1);
//		session.remove(std1);
		
//		Student s = session.get(Student.class, 1);
//		Student s = session.load(Student.class, 10);
		
		txn.commit();
		
		
//		System.out.println("student data from DB for id 1 : "+s);
		System.out.println("student object saved to DB successfully!!!");
		session.close();
		
		
		
		
	}

}
