package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory;
		// created only once
		// heavy object
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student("Pallagi", "Jozsef", "pallagijoe@gmail.com");
			Student student2 = new Student("Pallagi", "Eniko", "pallagiEniko@gmail.com");
			Student student3 = new Student("Pallagi", "Andrea", "pallagiAndrea@gmail.com");

			session.beginTransaction();
			session.save(student);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}
	
}
