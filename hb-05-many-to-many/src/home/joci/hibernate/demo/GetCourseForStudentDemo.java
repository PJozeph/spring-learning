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
import home.joci.hibernate.demo.entity.Student;

public class GetCourseForStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
		    
		    Student student = session.get(Student.class, 3);
		    Query getCoursesByStudentId = session.createQuery("SELECT c FROM Course c JOIN c.students s WHERE s.id=:studentId");
		    getCoursesByStudentId.setParameter("studentId", student.getId());
		    List<Course> courses = getCoursesByStudentId.getResultList();
			session.getTransaction().commit();

			courses.forEach(System.out::print);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
