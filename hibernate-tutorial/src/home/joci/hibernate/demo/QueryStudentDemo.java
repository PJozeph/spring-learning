package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory;
		// created only once
		// heavy object
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student("Pallagi", "József", "pallagijoe@gmail.com");

			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
