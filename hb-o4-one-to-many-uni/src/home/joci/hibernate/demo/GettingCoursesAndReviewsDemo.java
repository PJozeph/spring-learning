package home.joci.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import home.joci.hibernate.demo.entity.Course;
import home.joci.hibernate.demo.entity.Instructor;
import home.joci.hibernate.demo.entity.InstructorDetail;
import home.joci.hibernate.demo.entity.Review;

public class GettingCoursesAndReviewsDemo {

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

			int courseId = 10;

			Course course = session.get(Course.class, courseId);
			Query<Review> selectReviewsByCourseId = session.createQuery("SELECT r FROM Review r WHERE r.id=:courseId");
			selectReviewsByCourseId.setParameter("courseId", course.getId());
			

			List<Review> courses = selectReviewsByCourseId.getResultList();

			session.getTransaction().commit();

			courses.forEach(System.out::print);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
