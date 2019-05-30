package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			int instructorDetailId = 7;
			
			InstructorDetail instructorDetailes = session.get(InstructorDetail.class, instructorDetailId);

			instructorDetailes.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetailes);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
