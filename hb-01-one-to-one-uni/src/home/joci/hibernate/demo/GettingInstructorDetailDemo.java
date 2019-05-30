package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GettingInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			int instructorDetailId = 6;
			
			InstructorDetail instructorDetailes = session.get(InstructorDetail.class, instructorDetailId);

			System.out.println(instructorDetailes.getInstructor());
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
