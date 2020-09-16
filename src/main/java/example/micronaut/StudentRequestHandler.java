package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;

import example.micronaut.dynamodb.IDynamoDBService;
import example.micronaut.model.Student;

@Introspected
public class StudentRequestHandler extends MicronautRequestHandler<Student, Student> { // <1>

	private IDynamoDBService dynamoDBService;

	public StudentRequestHandler() {
		// TODO Auto-generated constructor stub
	}

	public StudentRequestHandler(IDynamoDBService dynamoDBService) {
		this.dynamoDBService = dynamoDBService;
	}

	@Override
	public Student execute(Student student) {
		return dynamoDBService.save(student);
	}
}
