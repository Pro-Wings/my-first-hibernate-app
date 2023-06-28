package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Student;
import com.prowings.entity.Student2;

public class TestHibernateAppMergenUpdateMethods {

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
		
		txn.commit();
		session.close();
		
		std1.setName("QQQQ");
		
		Session session2 = sf.openSession();
		
		Student2 std2 = session2.get(Student2.class, 4);
		Transaction txn2 = session2.beginTransaction();

//		session2.update(std1); //throws NoUniqObjectEx
		session2.merge(std1);
		txn2.commit();
		session2.close();

	}

}
