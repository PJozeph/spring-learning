package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.demo.entity.Course;
import home.joci.hibernate.demo.entity.Instructor;
import home.joci.hibernate.demo.entity.InstructorDetail;
import home.joci.hibernate.demo.entity.Review;
import home.joci.hibernate.demo.entity.Student;

public class AddMoreCourseToStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			Course course = new Course("Android DEvelopment");
			Course course2 = new Course("Ruby");
		    Course course3 = new Course("C++");
		    
		    Student student = session.get(Student.class, 3);
			
		    student.addCourse(course);
		    student.addCourse(course2);
		    student.addCourse(course3);
		    
		    session.save(course);
		    session.save(course2);
		    session.save(course3);
		    session.update(student);
		    
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
