package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.demo.entity.Course;
import home.joci.hibernate.demo.entity.Instructor;
import home.joci.hibernate.demo.entity.InstructorDetail;
import home.joci.hibernate.demo.entity.Review;
import home.joci.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentDemo {

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

			Course course = new Course("Java EE Principles");
			Course course2 = new Course("Designe Patterns");
		    Course course3 = new Course("Best Practices in Database");
		    
		    Student student = new Student("Jhon","Doe","jhon@gmail.com");
		    Student student2 = new Student("Merry","Doe","merry@gmail.com");
		    Student student3 = new Student("Sean","Doe","sean@gmail.com");
		    
		    course.addStudent(student);
		    course.addStudent(student2);
		    course.addStudent(student3);
			
		    session.save(student);
		    session.save(student2);
		    session.save(student3);
		    
		    
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
