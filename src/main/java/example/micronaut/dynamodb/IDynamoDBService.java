package example.micronaut.dynamodb;

import com.agorapulse.micronaut.aws.dynamodb.annotation.HashKey;
import com.agorapulse.micronaut.aws.dynamodb.annotation.RangeKey;
import com.agorapulse.micronaut.aws.dynamodb.annotation.Service;

import example.micronaut.model.Student;

@Service(Student.class)
public interface IDynamoDBService {

	Student save(Student student);

	void delete(Student student);

	Student get(@HashKey String studenId, @RangeKey String lastName);

}
