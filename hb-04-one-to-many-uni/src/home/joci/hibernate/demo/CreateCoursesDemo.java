package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.demo.entity.Course;
import home.joci.hibernate.demo.entity.Instructor;
import home.joci.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);
			Course course = new Course("Java EE Principles");
			Course course2 = new Course("Designe Patterns");
		    Course course3 = new Course("Best Practices in Database");
		    
			instructor.add(course);
			instructor.add(course2);
			instructor.add(course3);
			
			session.save(course);
			session.save(course2);
			session.save(course3);
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
