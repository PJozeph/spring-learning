package home.joci.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete Student s where s.id=7 ").executeUpdate();
			session.getTransaction().commit();
			
			int studentId = 12;
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			
			Student studentForDelete = session2.get(Student.class, studentId);
			
			session2.delete(studentForDelete);
			session2.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
