package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.demo.entity.Course;
import home.joci.hibernate.demo.entity.Instructor;
import home.joci.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		try {
			Session session = sessionFactory.getCurrentSession();
			
			Instructor instructor = new Instructor("Jhon","Doe","jhondoe@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("www.jhondoe.com","crossfit");
			
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
