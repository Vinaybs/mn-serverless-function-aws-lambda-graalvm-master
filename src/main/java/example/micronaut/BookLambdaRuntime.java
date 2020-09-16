package example.micronaut;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;
import java.net.MalformedURLException;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.umd.cs.findbugs.annotations.Nullable;
import example.micronaut.model.Student;

public class BookLambdaRuntime extends
		AbstractMicronautLambdaRuntime<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, Student, Student> {

	public static void main(String[] args) {
		try {
			new BookLambdaRuntime().run(args);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Nullable
	protected RequestHandler<Student, Student> createRequestHandler(String... args) {
		return new BookRequestHandler();
	}
}
