package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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
			
			Instructor instructor = new Instructor("Pallagi","József","pallagijoe@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("www.pallagijoe.com","crossfit");
			
			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
