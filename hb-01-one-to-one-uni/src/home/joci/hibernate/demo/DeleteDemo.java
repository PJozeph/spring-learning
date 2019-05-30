package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory;
		// created only once
		// heavy object
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			int instructorID = 1;
			
			Instructor instructor = session.get(Instructor.class, instructorID);

			session.delete(instructor);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
