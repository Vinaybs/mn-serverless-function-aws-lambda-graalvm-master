package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;

import example.micronaut.dynamodb.IDynamoDBService;
import example.micronaut.model.Student;

@Introspected
public class BookRequestHandler extends MicronautRequestHandler<Student, Student> { // <1>

	private IDynamoDBService dynamoDBService;

	public BookRequestHandler() {
		// TODO Auto-generated constructor stub
	}

	public BookRequestHandler(IDynamoDBService dynamoDBService) {
		this.dynamoDBService = dynamoDBService;
	}

	@Override
	public Student execute(Student student) {
		return dynamoDBService.save(student);
	}
}
