package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.demo.entity.Course;
import home.joci.hibernate.demo.entity.Instructor;
import home.joci.hibernate.demo.entity.InstructorDetail;
import home.joci.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			Instructor instructor = new Instructor("Jhon", "Doe", "jhon@gmail.com");
			Course course = new Course("Java EE Principles");
			Course course2 = new Course("Designe Patterns");
		    Course course3 = new Course("Best Practices in Database");
		    
		    Review review = new Review("I learn many things, I liked it");
		    Review review2 = new Review("I liked it");
		    Review review3 = new Review("It was too easy for me");
		    
		    course.addReview(review);
		    course2.addReview(review2);
		    course3.addReview(review3);
		    
			instructor.add(course);
			instructor.add(course2);
			instructor.add(course3);
			
			session.save(instructor);
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
