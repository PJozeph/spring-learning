package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			int studentId = 6;
			Student student = session.get(Student.class, studentId);
			student.setFirstName("Smith");
			
			session.getTransaction().commit();
			
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			
			System.out.println("Update email for all students");
			session2.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session2.getTransaction().commit();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sessionFactory.close();
		}
	}

}
