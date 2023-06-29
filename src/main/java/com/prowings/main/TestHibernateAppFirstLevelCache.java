package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Student;
import com.prowings.entity.Student2;

public class TestHibernateAppFirstLevelCache {
	
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

//		session.save(std1);
		
		Student2 s = session.get(Student2.class, 4);
		
		System.out.println(">>>>>>>>>>>> 1 >>>>>>>>>"+s);

//		Student2 s1 = session.get(Student2.class, 4);
//		
//		System.out.println(">>>>>>>>>>>> 2 >>>>>>>>>"+s1);
		
		txn.commit();
//		session.close();
		
//second session
		
		Session session2 = sf.openSession();
		Transaction txn2 = session2.beginTransaction();

//		session.save(std1);
		
		Student2 s2 = session2.get(Student2.class, 4);
		System.out.println(">>>>>>>>>>>> 2:1 >>>>>>>>>"+s2);

		Student2 s21 = session2.get(Student2.class, 4);
		System.out.println(">>>>>>>>>>>> 2:2 >>>>>>>>>"+s21);
		txn2.commit();
		session2.close();
		
		
	}

}
