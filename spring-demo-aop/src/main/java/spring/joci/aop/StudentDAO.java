package spring.joci.aop;

import org.springframework.stereotype.Component;

@Component
public class StudentDAO {

	public boolean addStudent() {
		System.out.println(getClass() + " : ADDING STUDENT");
		return true;
	}
}
