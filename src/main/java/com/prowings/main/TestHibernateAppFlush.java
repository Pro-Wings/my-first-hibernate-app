package com.prowings.main;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Student;
import com.prowings.entity.Student2;

public class TestHibernateAppFlush {

	public static void main(String[] args) {

		Student2 std1 = new Student2();
		std1.setId(4);
		std1.setRoll(123);
		std1.setName("AAA");
		std1.setAddress("ZZZ");

		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(std1);
		session.setFlushMode(FlushMode.MANUAL);
		session.flush();
		
//		txn.commit();
		
		session.close();
		
		

	}

}
