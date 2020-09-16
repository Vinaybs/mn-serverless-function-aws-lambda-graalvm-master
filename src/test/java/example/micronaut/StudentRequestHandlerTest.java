package example.micronaut;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import example.micronaut.model.Student;

public class StudentRequestHandlerTest {

	private static StudentRequestHandler studentRequestHandler;

	//@BeforeAll
	public static void setupServer() {
		studentRequestHandler = new StudentRequestHandler(); // <1>
	}

	//@AfterAll
	public static void stopServer() {
		if (studentRequestHandler != null) {
			studentRequestHandler.getApplicationContext().close(); // <2>
		}
	}

	//@Test
	public void testHandler() {
		Student student = new Student();
		student.setAge(20);
		student.setFirstName("Sam");
		student.setLastName("Diago");
		student.setStudentId("12345");
		Student student1 = studentRequestHandler.execute(student); // <3>
		assertEquals(student.getFirstName(), student1.getFirstName());
		assertNotNull(student.getStudentId());
	}
}
