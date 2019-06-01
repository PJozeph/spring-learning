package home.joci.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import home.joci.hibernate.demo.entity.Course;
import home.joci.hibernate.demo.entity.Instructor;
import home.joci.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			int theInstructorId = 1;
			
			Query<Instructor> selectInstructor = session.createQuery("SELECT i from Instructor i"
					+ " JOIN FETCH i.courses"
					+ " WHERE i.id=:theInstructorId",Instructor.class);
			selectInstructor.setParameter("theInstructorId", theInstructorId);

			Query<Course> selectCoursesQuery = session.createQuery("SELECT c from Course c"
					+ " WHERE c.instructor.id=:theInstructorId",Course.class);
			selectCoursesQuery.setParameter("theInstructorId", theInstructorId);
			List<Course> instructorCourse = selectCoursesQuery.getResultList();
			Instructor instructor = selectInstructor.getSingleResult();
			session.getTransaction().commit();
			
			
			System.out.println(instructor.getCourses());
			instructorCourse.forEach(System.out::print);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
