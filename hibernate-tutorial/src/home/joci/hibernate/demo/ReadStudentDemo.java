package home.joci.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.joci.hibernate.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();


		try {
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			
			students.forEach(System.out::println);
			System.err.println("Query student whose last name is Doe");
			
			List<Student> studentsDoe = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			studentsDoe.forEach(System.out::println);
			
			System.err.println("Query Student whose last name is Doe or first name is Duffy");
			List<Student> students3 = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Deffy'").getResultList();
			students3.forEach(System.out::println);
			
			System.err.println("query student whose emails is freemail");
			List<Student> studentEmail = session.createQuery("from Student s where s.email LIKE '%@freemail.com'").getResultList();
			studentEmail.forEach(System.out::println);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
