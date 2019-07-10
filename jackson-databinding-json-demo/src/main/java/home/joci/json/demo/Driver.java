package home.joci.json.demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			Student student = objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println(student);

			Address address = student.getAddress();

			System.out.println("The Street is " + address.getStreet());
			System.out.println("The City is " + address.getCity());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
